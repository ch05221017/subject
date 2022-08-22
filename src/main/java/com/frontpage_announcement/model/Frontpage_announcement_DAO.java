package com.frontpage_announcement.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Frontpage_announcement_DAO implements Frontpage_announcement_DAO_interface {

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
		"SELECT frontpage_announcement_serial_number,administrator_serial_number,frontpage_announcement_description,frontpage_announcement_onload_date,frontpage_announcement_offload_date,frontpage_announcement_status FROM frontpage_announcement order by frontpage_announcement_serial_number";
	private static final String GET_ONE_STMT = 
		"SELECT frontpage_announcement_serial_number,administrator_serial_number,frontpage_announcement_description,frontpage_announcement_onload_date,frontpage_announcement_offload_date,frontpage_announcement_status FROM frontpage_announcement where frontpage_announcement_serial_number = ?";
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
	public Frontpage_announcement_VO findByPrimaryKey(Integer frontpage_announcement_serial_number) {

		Frontpage_announcement_VO Frontpage_announcement_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frontpage_announcement_serial_number);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Frontpage_announcement_VO = new Frontpage_announcement_VO();
				Frontpage_announcement_VO.setFrontpage_announcement_serial_number(rs.getInt("frontpage_announcement_serial_number"));
				Frontpage_announcement_VO.setAdministrator_serial_number(rs.getInt("administrator_serial_number"));
				Frontpage_announcement_VO.setFrontpage_announcement_description(rs.getString("frontpage_announcement_description"));
				Frontpage_announcement_VO.setFrontpage_announcement_onload_date(rs.getDate("frontpage_announcement_onload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_offload_date(rs.getDate("frontpage_announcement_offload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_status(rs.getInt("frontpage_announcement_status"));
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
		return Frontpage_announcement_VO;
	}

	@Override
	public List<Frontpage_announcement_VO> getAll() {
		List<Frontpage_announcement_VO> list = new ArrayList<Frontpage_announcement_VO>();
		Frontpage_announcement_VO Frontpage_announcement_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Frontpage_announcement_VO = new Frontpage_announcement_VO();
				Frontpage_announcement_VO.setFrontpage_announcement_serial_number(rs.getInt("frontpage_announcement_serial_number"));
				Frontpage_announcement_VO.setAdministrator_serial_number(rs.getInt("administrator_serial_number"));
				Frontpage_announcement_VO.setFrontpage_announcement_description(rs.getString("frontpage_announcement_description"));
				Frontpage_announcement_VO.setFrontpage_announcement_onload_date(rs.getDate("frontpage_announcement_onload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_offload_date(rs.getDate("frontpage_announcement_offload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_status(rs.getInt("frontpage_announcement_status"));

				list.add(Frontpage_announcement_VO); // Store the row in the list
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
	public List<Frontpage_announcement_VO> getAll(Map<String, String[]> map) {
		List<Frontpage_announcement_VO> list = new ArrayList<Frontpage_announcement_VO>();
		Frontpage_announcement_VO Frontpage_announcement_VO = null;
	
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
				Frontpage_announcement_VO = new Frontpage_announcement_VO();
				Frontpage_announcement_VO.setFrontpage_announcement_serial_number(rs.getInt("frontpage_announcement_serial_number"));
				Frontpage_announcement_VO.setAdministrator_serial_number(rs.getInt("administrator_serial_number"));
				Frontpage_announcement_VO.setFrontpage_announcement_description(rs.getString("frontpage_announcement_description"));
				Frontpage_announcement_VO.setFrontpage_announcement_onload_date(rs.getDate("frontpage_announcement_onload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_offload_date(rs.getDate("frontpage_announcement_offload_date"));
				Frontpage_announcement_VO.setFrontpage_announcement_status(rs.getInt("frontpage_announcement_status"));

				list.add(Frontpage_announcement_VO); // Store the row in the List
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