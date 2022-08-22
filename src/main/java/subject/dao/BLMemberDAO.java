package subject.dao;

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

import subject.vo.BLMemberVO;

public class BLMemberDAO implements BLMemberDAO_interface {
	
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
			"select "
			+ "	b.black_list_number,"			
			+ "    s.company_member_account,"			
			+ "    m.member_account,"
			+ "    m.member_status  "
//			+" b.administrator_serial_number"
			+ " from black_list b "
			+ " join seller s "
			+ " on b.seller_serial_number = s.seller_serial_number "
			+ " join member m "
			+ " on b.member_serial_number = m.member_serial_number";
	private static final String GET_ONE_STMT =
			" select "
			+ "	b.black_list_number, "
			+ " s.company_member_account, "
			+ " m.member_account, "
			+ " m.member_status "
			+ " from black_list b "
			+ " join seller s "
			+ " on b.seller_serial_number = s.seller_serial_number "
			+ " join member m "
			+ " on b.member_serial_number = m.member_serial_number "
			+ " where b.black_list_number = ?";			
	private static final String UPDATE = 
			 "update (black_list b "
			 + "join seller s "
			 + "on b.seller_serial_number = s.seller_serial_number "
			 + "join member m "
			 + "on b.member_serial_number = m.member_serial_number) "
			 + "set m.member_status=? "
			 + "where b.black_list_number = ?";
	
	@Override
	public void update(BLMemberVO blmemberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, blmemberVO.getMemberstatus());
			pstmt.setInt(2, blmemberVO.getBlacklistid());
//			pstmt.setString(2, blmemberVO.getSellername());
//			pstmt.setString(3, blmemberVO.getMembername());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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
	}
		
	@Override
	public BLMemberVO findByPrimaryKey (Integer blacklistid) {

			BLMemberVO blmemberVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, blacklistid);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// blmemberVO 也稱為 Domain objects
					blmemberVO = new BLMemberVO();
					blmemberVO.setBlacklistid(rs.getInt("black_list_number"));
					blmemberVO.setSellername(rs.getString("company_member_account"));
					blmemberVO.setMembername(rs.getString("member_account"));
					blmemberVO.setMemberstatus(rs.getInt("member_status"));
//					blmemberVO.setAdmid(rs.getInt("administrator_serial_number"));
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
			return blmemberVO;
		}

		@Override
		public List<BLMemberVO> getAll() {
			List<BLMemberVO> list = new ArrayList<BLMemberVO>();
			BLMemberVO blmemberVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// blmemberVO 也稱為 Domain objects
					blmemberVO = new BLMemberVO();
					blmemberVO.setBlacklistid(rs.getInt("black_list_number"));
					blmemberVO.setSellername(rs.getString("company_member_account"));
					blmemberVO.setMembername(rs.getString("member_account"));
					blmemberVO.setMemberstatus(rs.getInt("member_status"));
//					blmemberVO.setAdmid(rs.getInt("administrator_serial_number"));
					list.add(blmemberVO); // Store the row in the list
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
