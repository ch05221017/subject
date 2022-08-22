package com.item_category.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Item_category_DAO implements Item_category_DAO_interface {

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
		"SELECT item_category_number,item_category_main_name FROM item_category order by item_category_number";
	private static final String GET_ONE_STMT = 
		"SELECT item_category_number,item_category_main_name FROM item_category where item_category_number = ?";
//	private static final String DELETE = 
//		"DELETE FROM item_category where item_category_number = ?";
//	private static final String UPDATE = 
//		"UPDATE item_category set setItem_category_main_name=?, setItem_category_area_name=?, setItem_category_detail_name=? where item_category_number = ?";

//	@Override
//	public void insert(Item_category_VO Item_category_VO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setString(1, Item_category_VO.getItem_category_main_name());
//			pstmt.setString(2, Item_category_VO.getItem_category_area_name());
//			pstmt.setString(3, Item_category_VO.getItem_category_detail_name());
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

//	@Override
//	public void update(Item_category_VO Item_category_VO) {
//
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
//
//			pstmt.setString(1, Item_category_VO.getItem_category_main_name());
//			pstmt.setString(2, Item_category_VO.getItem_category_area_name());
//			pstmt.setString(3, Item_category_VO.getItem_category_detail_name());
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
	public Item_category_VO findByPrimaryKey(Integer item_category_number) {

		Item_category_VO Item_category_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, item_category_number);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Item_category_VO = new Item_category_VO();
				Item_category_VO.setItem_category_number(rs.getInt("item_category_number"));
				Item_category_VO.setItem_category_main_name(rs.getString("item_category_main_name"));
//				Item_category_VO.setItem_category_area_name(rs.getString("item_category_area_name"));
//				Item_category_VO.setItem_category_detail_name(rs.getString("item_category_detail_name"));

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
		return Item_category_VO;
	}

	@Override
	public List<Item_category_VO> getAll() {
		List<Item_category_VO> list = new ArrayList<Item_category_VO>();
		Item_category_VO Item_category_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Item_category_VO = new Item_category_VO();
				Item_category_VO.setItem_category_number(rs.getInt("item_category_number"));
				Item_category_VO.setItem_category_main_name(rs.getString("item_category_main_name"));
//				Item_category_VO.setItem_category_area_name(rs.getString("item_category_area_name"));
//				Item_category_VO.setItem_category_detail_name(rs.getString("item_category_detail_name"));

				list.add(Item_category_VO); // Store the row in the list
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

	@Override
	public List<Item_category_VO> getAll(Map<String, String[]> map) {
		List<Item_category_VO> list = new ArrayList<Item_category_VO>();
		Item_category_VO Item_category_VO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			con = ds.getConnection();
			String finalSQL = "select * from emp2 "
		          + "order by empno";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				Item_category_VO = new Item_category_VO();
				Item_category_VO.setItem_category_number(rs.getInt("item_category_number"));
				Item_category_VO.setItem_category_main_name(rs.getString("item_category_main_name"));
//				Item_category_VO.setItem_category_area_name(rs.getString("item_category_area_name"));
//				Item_category_VO.setItem_category_detail_name(rs.getString("item_category_detail_name"));

				list.add(Item_category_VO); // Store the row in the List
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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