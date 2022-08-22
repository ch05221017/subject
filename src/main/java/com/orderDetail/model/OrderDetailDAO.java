package com.orderDetail.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDetailDAO implements OrderDetailDAO_interface{

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

	private static final String INSERT_OrderDetail_STMT = 
		"INSERT INTO order_detail (order_serial_number, item_serial_number, order_detail_price, order_detail_quantity, refund_reason, order_detail_status) VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ALL_OrderDetail_STMT = 
		"SELECT order_detail_serial_number, order_serial_number, item_serial_number, order_detail_price, order_detail_quantity, refund_reason, order_detail_status FROM order_detail order by order_detail_serial_number";
	
	private static final String GET_ONE_OrderDetail_STMT = 
	"SELECT d.order_detail_serial_number,d.order_serial_number,d.item_serial_number,d.order_detail_price,d.order_detail_quantity,d.refund_reason,d.order_detail_status,i.item_name,i.photo\r\n"
	+ "from order_detail d join item i \r\n"
	+ "on d.item_serial_number = i.item_serial_number\r\n"
	+ "WHERE d.item_serial_number = ?";
		
	private static final String DELETE_OrderDetail = 
		"DELETE FROM order_detail where order_detail_serial_number = ?";
	
	private static final String UPDATE_OrderDetail = 
		"UPDATE order_detail set order_serial_number = ?, item_serial_number = ?, order_detail_price = ?, order_detail_quantity = ?, refund_reason = ?, order_detail_status = ? where order_detail_serial_number = ?";
	
	private static final String GET_ItemName_Poto_ByOrderDetail = 
		"SELECT d.order_detail_serial_number,d.order_serial_number,d.item_serial_number,d.order_detail_price,d.order_detail_quantity,d.refund_reason,d.order_detail_status,i.item_name,i.photo\r\n"
		+ "from order_detail d join item i \r\n"
		+ "on d.item_serial_number = i.item_serial_number\r\n"
		+ "WHERE i.item_serial_number;";

	
	@Override
	public void insert(OrderDetailVO orderDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_OrderDetail_STMT);

			pstmt.setInt(1, orderDetailVO.getOrderserialnumber());
			pstmt.setInt(2, orderDetailVO.getItemserialnumber());
			pstmt.setInt(3, orderDetailVO.getOrderdetailprice());
			pstmt.setInt(4, orderDetailVO.getOrderdetailquantity());
			pstmt.setString(5, orderDetailVO.getRefundreason());
			pstmt.setInt(6, orderDetailVO.getOrderdetailstatus());

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
	public void update(OrderDetailVO orderDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_OrderDetail);
			
			pstmt.setInt(1, orderDetailVO.getOrderserialnumber());
			pstmt.setInt(2, orderDetailVO.getItemserialnumber());
			pstmt.setInt(3, orderDetailVO.getOrderdetailprice());
			pstmt.setInt(4, orderDetailVO.getOrderdetailquantity());
			pstmt.setString(5, orderDetailVO.getRefundreason());
			pstmt.setInt(6, orderDetailVO.getOrderdetailstatus());
			pstmt.setInt(7, orderDetailVO.getOrderdetailserialnumber());

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
	public void delete(Integer orderdetailserialnumber) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_OrderDetail);

			pstmt.setInt(1, orderdetailserialnumber);

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
	public OrderDetailVO findByOrderDetailPK(Integer orderdetailserialnumber) {

		OrderDetailVO orderDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_OrderDetail_STMT);

			pstmt.setInt(1, orderdetailserialnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// OrderDetailVO 也稱為 Domain objects
				orderDetailVO = new OrderDetailVO();
				orderDetailVO.setOrderdetailserialnumber(rs.getInt("order_detail_serial_number"));
				orderDetailVO.setOrderserialnumber(rs.getInt("order_serial_number"));
				orderDetailVO.setItemserialnumber(rs.getInt("item_serial_number"));
				orderDetailVO.setOrderdetailprice(rs.getInt("order_detail_price"));
				orderDetailVO.setOrderdetailquantity(rs.getInt("order_detail_quantity"));
				orderDetailVO.setRefundreason(rs.getString("refund_reason"));
				orderDetailVO.setOrderdetailstatus(rs.getInt("order_detail_status"));
				orderDetailVO.setItemname(rs.getString("item_name"));
				orderDetailVO.setPhoto(rs.getBytes("photo"));

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
		return orderDetailVO;
	}

	@Override
	public List<OrderDetailVO> getAllOrderDetail() {
		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		OrderDetailVO orderDetailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ItemName_Poto_ByOrderDetail);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// OrderDetailVO 也稱為 Domain objects
				orderDetailVO = new OrderDetailVO();
				orderDetailVO.setOrderdetailserialnumber(rs.getInt("order_detail_serial_number"));
				orderDetailVO.setOrderserialnumber(rs.getInt("order_serial_number"));
				orderDetailVO.setItemserialnumber(rs.getInt("item_serial_number"));
				orderDetailVO.setOrderdetailprice(rs.getInt("order_detail_price"));
				orderDetailVO.setOrderdetailquantity(rs.getInt("order_detail_quantity"));
				orderDetailVO.setRefundreason(rs.getString("refund_reason"));
				orderDetailVO.setOrderdetailstatus(rs.getInt("order_detail_status"));
				orderDetailVO.setItemname(rs.getString("item_name"));
				orderDetailVO.setPhoto(rs.getBytes("photo"));
				list.add(orderDetailVO); // Store the row in the list
				
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
	public void insert2 (OrderDetailVO orderDetailVO , Connection con) {

		PreparedStatement pstmt = null;

		try {

     		pstmt = con.prepareStatement(INSERT_OrderDetail_STMT);

			pstmt.setInt(1, orderDetailVO.getOrderserialnumber());
			pstmt.setInt(2, orderDetailVO.getItemserialnumber());
			pstmt.setInt(3, orderDetailVO.getOrderdetailprice());
			pstmt.setInt(4, orderDetailVO.getOrderdetailquantity());
			pstmt.setString(5, orderDetailVO.getRefundreason());
			pstmt.setInt(6, orderDetailVO.getOrderdetailstatus());


Statement stmt=	con.createStatement();
//stmt.executeUpdate("set auto_increment_offset=7001;"); //自增主鍵-初始值
stmt.executeUpdate("set auto_increment_increment=1;");   //自增主鍵-遞增
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					System.err.print("Transaction is being ");
					System.err.println("rolled back-由-emp");
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
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
		}

	}
}