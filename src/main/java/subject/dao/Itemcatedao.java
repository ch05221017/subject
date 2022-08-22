 package subject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import subject.vo.Itemcatevo;
import subject.vo.itemvo;



public class Itemcatedao implements Itemcatedaointerface {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
		private static final String GET_ITEM_BYITEMCATENO ="SELECT item_serial_number,item_name,item_description,item_price,item_stock,seller_serial_number,item_category_number FROM item where item_category_number = ? order by item_serial_number;";
		private static final String GET_ALL_STMT ="SELECT item_category_number, item_category_main_name FROM letitgo.item_category;";
		private static final String GET_ONE_STMT ="SELECT item_category_number, item_category_main_name FROM letitgo.item_category WHERE item_category_number=?;";
		
		@Override
		public Itemcatevo findByPrimaryKey(String categoryno) {

			Itemcatevo itemcatevo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setString(1,categoryno);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					
					itemcatevo = new Itemcatevo();
					itemcatevo.setCategoryno(rs.getString("item_category_number"));
					itemcatevo.setMainname(rs.getString("item_category_main_name"));					
				}
			} catch (SQLException se) {
				System.out.println("沒有抓到資料!");
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
			return itemcatevo;
		}		
		@Override
		public List<Itemcatevo> getAll() {
			List<Itemcatevo> list = new ArrayList<Itemcatevo>();
			Itemcatevo itemcatevo = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {

					itemcatevo = new Itemcatevo();
					itemcatevo.setCategoryno(rs.getString("item_category_number"));
					itemcatevo.setMainname(rs.getString("item_category_main_name"));
					list.add(itemcatevo); // Store the row in the list
				}
				// Handle any SQL errors
			} catch (SQLException se) {
				System.out.println("沒抓到資料!!!!");
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
		@Override
		public Set<itemvo> getItemByCateno(String categoryno) {
			Set<itemvo> set = new LinkedHashSet<itemvo>();
			itemvo itemvo = null;
		
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			try {
		
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ITEM_BYITEMCATENO);
				pstmt.setString(1, categoryno);
				rs = pstmt.executeQuery();
		
				while (rs.next()) {
					itemvo = new itemvo();
					itemvo.setSerialnumber(rs.getInt("item_serial_number"));
					itemvo.setName(rs.getString("item_name"));
					itemvo.setDescription(rs.getString("item_description"));
					itemvo.setPrice(rs.getInt("item_price"));
					itemvo.setStock(rs.getInt("item_stock"));
					itemvo.setCategoryno(rs.getString("item_category_number"));
					set.add(itemvo); // Store the row in the vector
				}	
			} catch (SQLException se) {
				System.out.println("資料未輸入!!");
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
			return set;
		}
		
		
	
}
