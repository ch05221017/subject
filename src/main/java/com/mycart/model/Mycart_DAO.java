package com.mycart.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Mycart_DAO implements Mycart_DAO_interface {

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

	private static final String INSERT_STMT = 
		"INSERT INTO cart_use_nosql1 (member_serial_number,item_serial_number,non_member_serial_number,cart_item_quantity) VALUES (?,?,?,?)";
	private static final String GET_ALL_STMT = 
		"SELECT cart_serial_number,member_serial_number,item_serial_number,non_member_serial_number,cart_item_quantity FROM cart_use_nosql1 order by cart_serial_number";
	private static final String GET_ONE_STMT = 
		"SELECT cart_serial_number,member_serial_number,item_serial_number,non_member_serial_number,cart_item_quantity FROM cart_use_nosql1 where cart_serial_number = ?";
	private static final String DELETE = 
		"DELETE FROM cart_use_nosql1 where cart_serial_number = ?";
//	private static final String UPDATE = 
//		"UPDATE item_category set setItem_category_main_name=?, setItem_category_area_name=?, setItem_category_detail_name=? where item_category_number = ?";

	
	@Override
	public void insert(Mycart_VO Mycart_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);


			pstmt.setInt(1, Mycart_VO.getMember_serial_number());
			pstmt.setInt(2, Mycart_VO.getItem_serial_number());
			pstmt.setInt(3, Mycart_VO.getNon_member_serial_number());
			pstmt.setInt(4, Mycart_VO.getCart_item_quantity());
//			pstmt.setString(3, Myfavorite_VO.getItem_category_detail_name());


			pstmt.executeUpdate();

			// Handle any SQL errors
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

	@Override
	public void delete(Integer cart_serial_number) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, cart_serial_number);

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
	public Mycart_VO findByPrimaryKey(Integer cart_serial_number) {

		Mycart_VO Mycart_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, cart_serial_number);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Mycart_VO = new Mycart_VO();
				pstmt.setInt(1, Mycart_VO.getCart_serial_number());
				pstmt.setInt(2, Mycart_VO.getMember_serial_number());
				pstmt.setInt(3, Mycart_VO.getItem_serial_number());
				pstmt.setInt(4, Mycart_VO.getNon_member_serial_number());
				pstmt.setInt(5, Mycart_VO.getCart_item_quantity());

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
		return Mycart_VO;
	}

	@Override
	public List<Mycart_VO> getAll() {
		List<Mycart_VO> list = new ArrayList<Mycart_VO>();
		Mycart_VO Mycart_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Item_category_VO 也稱為 Domain objects
				Mycart_VO = new Mycart_VO();

				Mycart_VO.setCart_serial_number(rs.getInt("cart_serial_number"));
				Mycart_VO.setMember_serial_number(rs.getInt("member_serial_number"));
				Mycart_VO.setItem_serial_number(rs.getInt("item_serial_number"));
				Mycart_VO.setNon_member_serial_number(rs.getInt("non_member_serial_number"));
				Mycart_VO.setCart_item_quantity(rs.getInt("cart_item_quantity"));


				list.add(Mycart_VO); // Store the row in the list
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
	public List<Mycart_VO> getAll(Map<String, String[]> map) {
		List<Mycart_VO> list = new ArrayList<Mycart_VO>();
		Mycart_VO Mycart_VO = null;
	
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
				Mycart_VO = new Mycart_VO();
				pstmt.setInt(1, Mycart_VO.getCart_serial_number());
				pstmt.setInt(2, Mycart_VO.getMember_serial_number());
				pstmt.setInt(3, Mycart_VO.getItem_serial_number());
				pstmt.setInt(4, Mycart_VO.getNon_member_serial_number());
				pstmt.setInt(5, Mycart_VO.getCart_item_quantity());

				list.add(Mycart_VO); // Store the row in the List
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