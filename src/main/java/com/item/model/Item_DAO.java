package com.item.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Item_DAO implements Item_DAO_interface {

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

//	private static final String INSERT_STMT = 
//		"INSERT INTO item_category (item_category_main_name,item_category_area_name,item_category_detail_name) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT item_serial_number,item_name,item_description,item_price,item_stock,seller_serial_number,item_category_number,photo FROM item order by item_serial_number";
	private static final String GET_ONE_STMT = 
		"SELECT item_serial_number,item_name,item_description,item_price,item_stock,seller_serial_number,item_category_number,photo FROM item where item_serial_number = ?";
//	private static final String DELETE = 
//		"DELETE FROM item_category where item_category_number = ?";
//	private static final String UPDATE = 
//		"UPDATE item_category set setItem_category_main_name=?, setItem_category_area_name=?, setItem_category_detail_name=? where item_category_number = ?";
//
//	@Override
//	public void insert(Item_VO item_VO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setString(1, item_VO.getItem_category_main_name());
//			pstmt.setString(2, item_VO.getItem_category_area_name());
//			pstmt.setString(3, item_VO.getItem_category_detail_name());
//
//
//			pstmt.executeUpdate();
//
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void update(Item_VO item_VO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
//
//			pstmt.setString(1, item_VO.getItem_category_main_name());
//			pstmt.setString(2, item_VO.getItem_category_area_name());
//			pstmt.setString(3, item_VO.getItem_category_detail_name());
//
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void delete(Integer item_category_number) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(DELETE);
//
//			pstmt.setInt(1, item_category_number);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//			// Clean up JDBC resources
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}

	@Override
	public Item_VO findByPrimaryKey(Integer item_serial_number) {

		Item_VO item_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, item_serial_number);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// item_VO 也稱為 Domain objects
				item_VO = new Item_VO();
				item_VO.setItem_serial_number(rs.getInt("item_serial_number"));
				item_VO.setItem_name(rs.getString("item_name"));
				item_VO.setItem_description(rs.getString("item_description"));
				item_VO.setItem_price(rs.getInt("item_price"));
				item_VO.setItem_stock(rs.getInt("item_stock"));
				item_VO.setSeller_serial_number(rs.getInt("seller_serial_number"));
				item_VO.setItem_category_number(rs.getString("item_category_number"));
				item_VO.setPhoto(rs.getBytes("photo"));

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
		return item_VO;
	}

	@Override
	public List<Item_VO> getAll() {
		List<Item_VO> list = new ArrayList<Item_VO>();
		Item_VO item_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// item_VO 也稱為 Domain objects
				item_VO = new Item_VO();
				item_VO.setItem_serial_number(rs.getInt("item_serial_number"));
				item_VO.setItem_name(rs.getString("item_name"));
				item_VO.setItem_description(rs.getString("item_description"));
				item_VO.setItem_price(rs.getInt("item_price"));
				item_VO.setItem_stock(rs.getInt("item_stock"));
				item_VO.setSeller_serial_number(rs.getInt("seller_serial_number"));
				item_VO.setItem_category_number(rs.getString("item_category_number"));
				item_VO.setPhoto(rs.getBytes("photo"));

				list.add(item_VO); // Store the row in the list
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

//	@Override
//	public List<Item_VO> getAll(Map<String, String[]> map) {
//		List<Item_VO> list = new ArrayList<Item_VO>();
//		Item_VO item_VO = null;
//	
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	
//		try {
//			
//			con = ds.getConnection();
//			String finalSQL = "select * from emp2 "
//		          + "order by empno";
//			pstmt = con.prepareStatement(finalSQL);
////			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
//			rs = pstmt.executeQuery();
//	
//			while (rs.next()) {
//				item_VO = new Item_VO();
//				item_VO.setItem_serial_number(rs.getInt("item_serial_number"));
//				item_VO.setItem_name(rs.getString("item_name"));
//				item_VO.setItem_description(rs.getString("item_description"));
//				item_VO.setItem_price(rs.getInt("item_price"));
//				item_VO.setItem_stock(rs.getInt("item_stock"));
//				item_VO.setSeller_serial_number(rs.getInt("seller_serial_number"));
//				item_VO.setItem_category_number(rs.getString("item_category_number"));
//				item_VO.setItem_status_number(rs.getString("item_status_number"));
//
//				list.add(item_VO); // Store the row in the List
//			}
//	
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
//		return list;
//	}
}