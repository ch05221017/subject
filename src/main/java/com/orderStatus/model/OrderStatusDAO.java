package com.orderStatus.model;

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

import com.orderMainFile.model.OrderMainFileVO;

public class OrderStatusDAO implements OrderStatusDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO order_status (order_status_name) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT order_status_number , order_status_name FROM order_status";
	private static final String GET_ONE_STMT = "SELECT order_status_number , order_status_name FROM order_status where order_status_number = ?";
	private static final String GET_OrderMainFiles_ByOrderstatusnumber_STMT = "SELECT order_serial_number, member_serial_number, seller_serial_number, order_status_number, coupon_serial_number, seller_evaluation_star, member_evaluation_star, seller_evaluation_description, member_evaluation_description, order_amount, order_date FROM order_main_file where order_status_number = ? order by order_serial_number";
	
	private static final String DELETE_OrderMainFiles = "DELETE FROM order_main_file where order_status_number = ?";
	private static final String DELETE_OrderStatus = "DELETE FROM order_status where order_status_number = ?";	
	
	private static final String UPDATE = "UPDATE order_status set order_status_name=? where order_status_number = ?";

	@Override
	public void insert(OrderStatusVO orderStatusVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, orderStatusVO.getOrderstatusname());

pstmt.executeUpdate("set auto_increment_offset=10;");
pstmt.executeUpdate("set auto_increment_increment=10;");
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

	@Override
	public void update(OrderStatusVO orderStatusVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, orderStatusVO.getOrderstatusname());
			pstmt.setString(2, orderStatusVO.getOrderstatusnumber());

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

	@Override
	public void delete(String orderstatusnumber) {
		int updateCount_OrderMainFiles = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();

			// 1●設定於 pstm.executeUpdate()之前
			con.setAutoCommit(false);

			// 先刪除訂單
			pstmt = con.prepareStatement(DELETE_OrderMainFiles);
			pstmt.setString(1, orderstatusnumber);
			updateCount_OrderMainFiles = pstmt.executeUpdate();
			// 再刪除訂單狀態
			pstmt = con.prepareStatement(DELETE_OrderStatus);
			pstmt.setString(1, orderstatusnumber);
			pstmt.executeUpdate();

			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除訂單狀態編號" + orderstatusnumber + "時,共有訂單" + updateCount_OrderMainFiles
					+ "筆同時被刪除");
			
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public OrderStatusVO findByPrimaryKey(String orderstatusnumber) {

		OrderStatusVO orderStatusVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, orderstatusnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// orderStatusVO 也稱為 Domain objects
				orderStatusVO = new OrderStatusVO();
				orderStatusVO.setOrderstatusnumber(rs.getString("order_status_number"));
				orderStatusVO.setOrderstatusname(rs.getString("order_status_name"));
			}

			// Handle any SQL errors
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
		return orderStatusVO;
	}

	@Override
	public List<OrderStatusVO> getAll() {
		List<OrderStatusVO> list = new ArrayList<OrderStatusVO>();
		OrderStatusVO orderStatusVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderStatusVO = new OrderStatusVO();
				orderStatusVO.setOrderstatusnumber(rs.getString("order_status_number"));
				orderStatusVO.setOrderstatusname(rs.getString("order_status_name"));
				list.add(orderStatusVO); // Store the row in the list
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

	@Override
	public Set<OrderMainFileVO> getOrderMainFilesByOrderStatusNumber(String orderstatusnumber) {
		Set<OrderMainFileVO> set = new LinkedHashSet<OrderMainFileVO>();
		OrderMainFileVO orderMainFileVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_OrderMainFiles_ByOrderstatusnumber_STMT);
			pstmt.setString(1, orderstatusnumber);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				orderMainFileVO = new OrderMainFileVO();
				orderMainFileVO.setOrderserialnumber(rs.getInt("order_serial_number"));
				orderMainFileVO.setMemberserialnumber(rs.getInt("member_serial_number"));
				orderMainFileVO.setSellerserialnumber(rs.getInt("seller_serial_number"));
				orderMainFileVO.setOrderstatusnumber(rs.getString("order_status_number"));
				orderMainFileVO.setCouponserialnumber(rs.getInt("coupon_serial_number"));
				orderMainFileVO.setSellerevaluationstar(rs.getInt("seller_evaluation_star"));
				orderMainFileVO.setMemberevaluationstar(rs.getInt("member_evaluation_star"));
				orderMainFileVO.setSellerevaluationdescription(rs.getString("seller_evaluation_description"));
				orderMainFileVO.setMemberevaluationdescription(rs.getString("member_evaluation_description"));
//				orderMainFileVO.setMemberevaluationphoto(rs.getBytes("member_evaluation_photo"));
				orderMainFileVO.setOrderamount(rs.getInt("order_amount"));
				orderMainFileVO.setOrderdate(rs.getDate("order_date"));
				set.add(orderMainFileVO); // Store the row in the vector
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
		return set;
	}
}