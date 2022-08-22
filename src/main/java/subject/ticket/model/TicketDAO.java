package subject.ticket.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class TicketDAO implements TicketDAO_interface{

	
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		private static final String GET_ALL_STMT = 
				"select omf.order_serial_number,order_detail_serial_number,item_name,order_date,order_status_name,omf.member_serial_number from order_main_file omf join order_detail od on omf.order_serial_number = od.order_serial_number join item i on od.item_serial_number = i.item_serial_number join order_status os on omf.order_status_number = os.order_status_number join member m on m.member_serial_number = omf.member_serial_number order by omf.order_serial_number";
		
		@Override
		public List<TicketVO> getAll() {
			List<TicketVO> list = new ArrayList<TicketVO>();
			TicketVO ticketVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVO 也稱為 Domain objects
					ticketVO = new TicketVO();				
					ticketVO.setOrderserialnumber(rs.getInt("order_serial_number"));
					ticketVO.setOrderdetailserialnumber(rs.getInt("order_detail_serial_number"));
					ticketVO.setItemname(rs.getString("item_name"));
					ticketVO.setOrderdate(rs.getDate("order_date"));
					ticketVO.setOrderstatusname(rs.getString("order_status_name"));									
					ticketVO.setMemberserialnumber(rs.getInt("member_serial_number"));
					list.add(ticketVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return list;
		}


	
}
