package com.advert.model;

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

import com.orderDetail.model.OrderDetailVO;

public class advertDAO implements advertDAO_interface{

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
		
//		private static final String GET_ALL_STMT = 
//			"SELECT advertisement_serial_number, administrator_serial_number, advertisement_description, advertisement_photo, item_serial_number from advertisement order by advertisement_serial_number;";
		private static final String GET_ONE_STMT = 
			"SELECT advertisement_serial_number, administrator_serial_number, advertisement_description, advertisement_photo, item_serial_number from advertisement where advertisement_serial_number=?;";
		private static final String INSERT = 
			"INSERT INTO advertisement (administrator_serial_number, advertisement_description, advertisement_photo, item_serial_number) VALUES(?,?,?,?);";
		private static final String UPDATE =
			"UPDATE advertisement set administrator_serial_number = ?, advertisement_description = ?, advertisement_photo = ?, item_serial_number = ? where advertisement_serial_number = ?";
		private static final String DELETE =
			"DELETE FROM advertisement where advertisement_serial_number = ? ;";
		
		private static final String GET_ALL_STMT = 
			"select ad.advertisement_serial_number,ad.administrator_serial_number,ad.advertisement_description,\r\n"
			+ "ad.advertisement_photo,ad.item_serial_number,a.administrator_account,i.item_name,i.photo,i.seller_serial_number,s.company_member_account\r\n"
			+ "from advertisement ad\r\n"
			+ "join administrator a\r\n"
			+ "on ad.administrator_serial_number = a.administrator_serial_number\r\n"
			+ "join item i\r\n"
			+ "on ad.item_serial_number= i.item_serial_number\r\n"
			+ "join seller s\r\n"
			+ "on i.seller_serial_number= s.seller_serial_number\r\n"
			+ "order by ad.item_serial_number";
		
		private static final String GET_ITEM_PHOTO = 
			"select ad.advertisement_serial_number,ad.administrator_serial_number,ad.advertisement_description,\r\n"
			+ "ad.advertisement_photo,ad.item_serial_number,a.administrator_account,i.item_name,i.photo\r\n"
			+ "from advertisement ad\r\n"
			+ "join administrator a\r\n"
			+ "on ad.administrator_serial_number = a.administrator_serial_number\r\n"
			+ "join item i\r\n"
			+ "on ad.item_serial_number= i.item_serial_number\r\n"
			+ "where ad.item_serial_number = ?";
		
		
		@Override
		public advertVO findByItemPK(Integer itemserialnumber) {

			advertVO advertvo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ITEM_PHOTO);

				pstmt.setInt(1, itemserialnumber);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// OrderDetailVO 也稱為 Domain objects
					advertvo = new advertVO();
//					advertvo.setAdvertserialnumber(rs.getInt("advertisement_serial_number"));
//					advertvo.setAdminserialnumber(rs.getInt("administrator_serial_number"));
//					advertvo.setAdvertdescription(rs.getString("advertisement_description"));
//					advertvo.setAdvertphoto(rs.getBytes("advertisement_photo"));
//					advertvo.setItemserialnumber(rs.getInt("item_serial_number"));
//					advertvo.setAdminaccount(rs.getString("administrator_account"));
//					advertvo.setItemname(rs.getString("item_name"));
					advertvo.setPhoto(rs.getBytes("photo"));

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
			return advertvo;
		}
		
	
		@Override
		public advertVO findByPrimaryKey(Integer advertserialnumber) {

			advertVO advertvo = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, advertserialnumber);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// advertVO 也稱為 Domain objects
					advertvo = new advertVO();
					advertvo.setAdvertserialnumber(rs.getInt("advertisement_serial_number"));
					advertvo.setAdminserialnumber(rs.getInt("administrator_serial_number"));
					advertvo.setAdvertdescription(rs.getString("advertisement_description"));
					advertvo.setAdvertphoto(rs.getBytes("advertisement_photo"));
					advertvo.setItemserialnumber(rs.getInt("item_serial_number"));
					
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
			return advertvo;
		}

			
		
		@Override
		public List<advertVO> getAll() {
			List<advertVO> list = new ArrayList<advertVO>();
			advertVO advertvo = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// advertVO 也稱為 Domain objects
					advertvo = new advertVO();
					advertvo.setAdvertserialnumber(rs.getInt("advertisement_serial_number"));
					advertvo.setAdminserialnumber(rs.getInt("administrator_serial_number"));
					advertvo.setAdvertdescription(rs.getString("advertisement_description"));
					advertvo.setAdvertphoto(rs.getBytes("advertisement_photo"));
					advertvo.setItemserialnumber(rs.getInt("item_serial_number"));
					advertvo.setAdminaccount(rs.getString("administrator_account"));
					advertvo.setItemname(rs.getString("item_name"));
					advertvo.setPhoto(rs.getBytes("photo"));
					advertvo.setSellerserialnumber(rs.getInt("seller_serial_number"));
					advertvo.setCompanyaccount(rs.getString("company_member_account"));
					list.add(advertvo); // Store the row in the list							
					
				}
				// Handle any driver errors
			} catch (SQLException se) {
				System.out.println("111");
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
		public void insert(advertVO advertvo) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT);

				pstmt.setInt(1, advertvo.getAdminserialnumber());
				pstmt.setString(2, advertvo.getAdvertdescription());
				pstmt.setBytes(3, advertvo.getAdvertphoto());
				pstmt.setInt(4, advertvo.getItemserialnumber());

				pstmt.executeUpdate();						
			} catch (SQLException se) {
				System.out.println("資料沒進去");
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
		public void update(advertVO advertvo) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);
								
				pstmt.setInt(1, advertvo.getAdminserialnumber());
				pstmt.setString(2, advertvo.getAdvertdescription());
				pstmt.setBytes(3, advertvo.getAdvertphoto());
				pstmt.setInt(4, advertvo.getItemserialnumber());				
				pstmt.setInt(5, advertvo.getAdvertserialnumber());				
				
				pstmt.executeUpdate();
			} catch (SQLException se) {
				System.out.println("資料沒進去");
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
		public void delete(Integer advertserialnumber) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, advertserialnumber);

				pstmt.executeUpdate();
			} catch (SQLException se) {
				System.out.println("資料沒刪掉");
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
	}