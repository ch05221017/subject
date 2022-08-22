package com.product_seller.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Product_seller_DAO implements Product_seller_DAO_interface {

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
		"SELECT seller_serial_number,company_name,company_member_account,company_member_password,id_number,seller_email,company_holder,company_holder_id,seller_phone_number,seller_main_address,seller_branch_address,store_description,administrator_revise_date,seller_evaluate_quantity,seller_evaluate_stars FROM seller order by seller_serial_number";
	private static final String GET_ONE_STMT = 
		"SELECT seller_serial_number,company_name,company_member_account,company_member_password,id_number,seller_email,company_holder,company_holder_id,seller_phone_number,seller_main_address,seller_branch_address,store_description,administrator_revise_date,seller_evaluate_quantity,seller_evaluate_stars FROM seller where seller_serial_number = ?";
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
	public Product_seller_VO findByPrimaryKey(Integer seller_serial_number) {

		Product_seller_VO Product_seller_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, seller_serial_number);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// item_VO 也稱為 Domain objects
				Product_seller_VO = new Product_seller_VO();
				Product_seller_VO.setSeller_serial_number(rs.getInt("seller_serial_number"));
				Product_seller_VO.setCompany_name(rs.getString("company_name"));
				Product_seller_VO.setCompany_member_account(rs.getString("company_member_account"));
				Product_seller_VO.setCompany_member_password(rs.getString("company_member_password"));
				Product_seller_VO.setId_number(rs.getString("id_number"));
				Product_seller_VO.setSeller_email(rs.getString("seller_email"));
				Product_seller_VO.setCompany_holder(rs.getString("company_holder"));
				Product_seller_VO.setCompany_holder_id(rs.getString("company_holder_id"));
				Product_seller_VO.setSeller_phone_number(rs.getString("seller_phone_number"));
				Product_seller_VO.setSeller_main_address(rs.getString("seller_main_address"));
				Product_seller_VO.setSeller_branch_address(rs.getString("seller_branch_address"));
				Product_seller_VO.setStore_description(rs.getString("store_description"));
				Product_seller_VO.setAdministrator_revise_date(rs.getDate("administrator_revise_date"));
				Product_seller_VO.setSeller_evaluate_quantity(rs.getInt("seller_evaluate_quantity"));
				Product_seller_VO.setSeller_evaluate_stars(rs.getInt("seller_evaluate_stars"));

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
		return Product_seller_VO;
	}

	@Override
	public List<Product_seller_VO> getAll() {
		List<Product_seller_VO> list = new ArrayList<Product_seller_VO>();
		Product_seller_VO Product_seller_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				
				Product_seller_VO = new Product_seller_VO();
				Product_seller_VO.setSeller_serial_number(rs.getInt("seller_serial_number"));
				Product_seller_VO.setCompany_name(rs.getString("company_name"));
				Product_seller_VO.setCompany_member_account(rs.getString("company_member_account"));
				Product_seller_VO.setCompany_member_password(rs.getString("company_member_password"));
				Product_seller_VO.setId_number(rs.getString("id_number"));
				Product_seller_VO.setSeller_email(rs.getString("seller_email"));
				Product_seller_VO.setCompany_holder(rs.getString("company_holder"));
				Product_seller_VO.setCompany_holder_id(rs.getString("company_holder_id"));
				Product_seller_VO.setSeller_phone_number(rs.getString("seller_phone_number"));
				Product_seller_VO.setSeller_main_address(rs.getString("seller_main_address"));
				Product_seller_VO.setSeller_branch_address(rs.getString("seller_branch_address"));
				Product_seller_VO.setStore_description(rs.getString("store_description"));
				Product_seller_VO.setAdministrator_revise_date(rs.getDate("administrator_revise_date"));
				Product_seller_VO.setSeller_evaluate_quantity(rs.getInt("seller_evaluate_quantity"));
				Product_seller_VO.setSeller_evaluate_stars(rs.getInt("seller_evaluate_stars"));

				list.add(Product_seller_VO); // Store the row in the list
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