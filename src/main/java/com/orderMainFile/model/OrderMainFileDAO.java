package com.orderMainFile.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.orderDetail.model.OrderDetailDAO;
import com.orderDetail.model.OrderDetailVO;

public class OrderMainFileDAO implements OrderMainFileDAO_interface{

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
		"INSERT INTO order_main_file (member_serial_number, seller_serial_number, order_status_number, coupon_serial_number, seller_evaluation_star, member_evaluation_star, seller_evaluation_description, member_evaluation_description, order_amount, order_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String GET_ALL_STMT = 
//		"SELECT order_serial_number, member_serial_number, seller_serial_number, order_status_number, coupon_serial_number, seller_evaluation_star, member_evaluation_star, seller_evaluation_description, member_evaluation_description, order_amount, order_date FROM order_main_file order by order_serial_number";
	private static final String GET_ONE_STMT = 
		"SELECT order_serial_number, member_serial_number, seller_serial_number, order_status_number, coupon_serial_number, seller_evaluation_star, member_evaluation_star, seller_evaluation_description, member_evaluation_description, order_amount, order_date FROM order_main_file where order_serial_number = ?";
	private static final String DELETE = 
		"DELETE FROM order_main_file where order_serial_number = ?";
	private static final String UPDATE = 
		"UPDATE order_main_file set member_serial_number = ?, seller_serial_number = ?, order_status_number = ?, coupon_serial_number = ?, seller_evaluation_star = ?, member_evaluation_star = ?, seller_evaluation_description = ?, member_evaluation_description = ?, order_amount = ?, order_date = ? where order_serial_number = ?";

	// 訂單流水編號join訂單明細(方法1)
	private static final String GET_OrderDetail_STMT = 
		"SELECT d.order_serial_number,d.item_serial_number,d.order_detail_price,d.order_detail_quantity,d.refund_reason,d.order_detail_status from order_main_file o join order_detail d on o.order_serial_number = d.order_serial_number\r\n"
		+ "WHERE d.order_serial_number";
	
	// 訂單流水編號join訂單明細(方法2)
	// private static final String GET_OD_ByOSN_STMT = "SELECT order_serial_number,item_serial_number,order_detail_price,order_detail_quantity,refund_reason,order_detail_status FROM order_detail where order_serial_number = ? order by order_detail_serial_number";
	
	//join賣場名稱、優惠券名稱
//	private static final String GET_Companyname_Couponname = 
//			"Select * from (SELECT o.order_serial_number,o.member_serial_number,o.seller_serial_number,o.order_status_number,o.coupon_serial_number,o.seller_evaluation_star,o.member_evaluation_star,o.seller_evaluation_description,o.member_evaluation_description,o.order_amount,o.order_date,s.company_name\r\n"
//			+ "from order_main_file o \r\n"
//			+ "join seller s on o.seller_serial_number = s.seller_serial_number\r\n"
//			+ "WHERE o.seller_serial_number)\r\n"
//			+ "ad JOIN coupon c ON ad.coupon_serial_number = c.coupon_serial_number";
	
	//join賣場名稱、優惠券名稱、會員帳號、會員帳號
	private static final String GET_ALL_STMT = 
			"select o.order_serial_number,o.member_serial_number,o.seller_serial_number,\r\n"
			+ "o.order_status_number,o.coupon_serial_number,o.seller_evaluation_star,\r\n"
			+ "o.member_evaluation_star,o.seller_evaluation_description,o.member_evaluation_description,\r\n"
			+ "o.order_amount,o.order_date,s.company_name,c.coupon_name,m.member_account\r\n"
			+ "from order_main_file o\r\n"
			+ "join seller s\r\n"
			+ "on o.seller_serial_number = s.seller_serial_number\r\n"
			+ "join coupon c\r\n"
			+ "on o.coupon_serial_number= c.coupon_serial_number\r\n"
			+ "join member m\r\n"
			+ "on o.member_serial_number= m.member_serial_number\r\n"
			+ "where o.order_serial_number";
	
	
	// 取得mail訂單編號
	private static final String getOrderNumber = "SELECT order_serial_number FROM letitgo.order_main_file ORDER BY order_serial_number DESC LIMIT 0 , 1";
	
	@Override
	public Integer getOrderMail() {
		Integer newOrder = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(getOrderNumber);) {
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					newOrder = rs.getInt("order_serial_number");
				}
				return newOrder;
			} catch (Exception e) {
			}
		} catch (Exception e) {

		}
		return null;
	}
		
	@Override
	public List<OrderMainFileVO> getAll() {
		List<OrderMainFileVO> list = new ArrayList<OrderMainFileVO>();
		OrderMainFileVO orderMainFileVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// orderMainFileVO 也稱為 Domain objects
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
				orderMainFileVO.setOrderamount(rs.getInt("order_amount"));
				orderMainFileVO.setOrderdate(rs.getDate("order_date"));
				orderMainFileVO.setCompanyname(rs.getString("company_name"));
				orderMainFileVO.setCouponname(rs.getString("coupon_name"));
				orderMainFileVO.setMemberaccount(rs.getString("member_account"));
				
				list.add(orderMainFileVO); // Store the row in the list
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
	
	// 訂單流水編號join訂單明細
	@Override
	public List<OrderDetailVO> findByOrderDetail(Integer orderserialnumber) {

		List<OrderDetailVO>list = new ArrayList<OrderDetailVO>();
		OrderDetailVO orderDetailVO =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_OrderDetail_STMT);

			pstmt.setInt(1, orderserialnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// orderDetailVO 也稱為 Domain objects
				orderDetailVO = new OrderDetailVO();
				orderDetailVO.setOrderserialnumber(rs.getInt("order_serial_number"));
				orderDetailVO.setItemserialnumber(rs.getInt("item_serial_number"));
				orderDetailVO.setOrderdetailprice(rs.getInt("order_detail_price"));
				orderDetailVO.setOrderdetailquantity(rs.getInt("order_detail_quantity"));
				orderDetailVO.setRefundreason(rs.getString("refund_reason"));
				orderDetailVO.setOrderdetailstatus(rs.getInt("order_detail_status"));

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
	public void insert(OrderMainFileVO orderMainFileVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);	

			pstmt.setInt(1, orderMainFileVO.getMemberserialnumber());
			pstmt.setInt(2, orderMainFileVO.getSellerserialnumber());
			pstmt.setString(3, orderMainFileVO.getOrderstatusnumber());
			pstmt.setInt(4, orderMainFileVO.getCouponserialnumber());
			pstmt.setInt(5, orderMainFileVO.getSellerevaluationstar());
			pstmt.setInt(6, orderMainFileVO.getMemberevaluationstar());
			pstmt.setString(7, orderMainFileVO.getSellerevaluationdescription());
			pstmt.setString(8, orderMainFileVO.getMemberevaluationdescription());
			pstmt.setInt(9, orderMainFileVO.getOrderamount());
			pstmt.setDate(10, orderMainFileVO.getOrderdate());

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
	public void update(OrderMainFileVO orderMainFileVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, orderMainFileVO.getMemberserialnumber());
			pstmt.setInt(2, orderMainFileVO.getSellerserialnumber());
			pstmt.setString(3, orderMainFileVO.getOrderstatusnumber());
			pstmt.setInt(4, orderMainFileVO.getCouponserialnumber());
			pstmt.setInt(5, orderMainFileVO.getSellerevaluationstar());
			pstmt.setInt(6, orderMainFileVO.getMemberevaluationstar());
			pstmt.setString(7, orderMainFileVO.getSellerevaluationdescription());
			pstmt.setString(8, orderMainFileVO.getMemberevaluationdescription());
			pstmt.setInt(9, orderMainFileVO.getOrderamount());
			pstmt.setDate(10, orderMainFileVO.getOrderdate());
			pstmt.setInt(11, orderMainFileVO.getOrderserialnumber());

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
	public void delete(Integer orderserialnumber) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orderserialnumber);

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
	public OrderMainFileVO findByOrderPK(Integer orderserialnumber) {

		OrderMainFileVO orderMainFileVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orderserialnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// orderMainFileVO 也稱為 Domain objects
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
				orderMainFileVO.setOrderamount(rs.getInt("order_amount"));
				orderMainFileVO.setOrderdate(rs.getDate("order_date"));
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
		return orderMainFileVO;
	}
	
	// 同時新增訂單主檔及訂單明細
		@Override
		public void insertWithOrderDetail(OrderMainFileVO orderMainFileVO , List<OrderDetailVO> list) {

			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				// 1●設定於 pstm.executeUpdate()之前
	    		con.setAutoCommit(false);
				
	    		// 先新增ordermainfile
				String cols[] = {"1"};
				pstmt = con.prepareStatement(INSERT_STMT , cols);			

				pstmt.setInt(1, orderMainFileVO.getMemberserialnumber());
				pstmt.setInt(2, orderMainFileVO.getSellerserialnumber());
				pstmt.setString(3, orderMainFileVO.getOrderstatusnumber());
				pstmt.setInt(4, orderMainFileVO.getCouponserialnumber());
				pstmt.setInt(5, orderMainFileVO.getSellerevaluationstar());
				pstmt.setInt(6, orderMainFileVO.getMemberevaluationstar());
				pstmt.setString(7, orderMainFileVO.getSellerevaluationdescription());
				pstmt.setString(8, orderMainFileVO.getMemberevaluationdescription());
				pstmt.setInt(9, orderMainFileVO.getOrderamount());
				pstmt.setDate(10, orderMainFileVO.getOrderdate());

	Statement stmt=	con.createStatement();
	stmt.executeUpdate("set auto_increment_offset=1;");    //自增主鍵-初始值
	stmt.executeUpdate("set auto_increment_increment=1;"); //自增主鍵-遞增
				pstmt.executeUpdate();
				//掘取對應的自增主鍵值
				Integer newOrderserialnumber = null;
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					newOrderserialnumber = rs.getInt(1);
					System.out.println("自增主鍵值= " + newOrderserialnumber +"第一筆訂單");
				} else {
					System.out.println("未取得自增主鍵值");
				}
				rs.close();
				// 再同時新增orderdetail
				OrderDetailDAO dao = new OrderDetailDAO();
				System.out.println("list.size()-A="+list.size());
				for (OrderDetailVO aOrderDetail : list) {
					aOrderDetail.setOrderserialnumber(new Integer(newOrderserialnumber)) ;
					dao.insert2(aOrderDetail,con);
				}

				// 2●設定於 pstm.executeUpdate()之後
				con.commit();
				con.setAutoCommit(true);
				System.out.println("list.size()-B="+list.size());
				System.out.println("新增訂單流水編號" + newOrderserialnumber + "時,共有訂單明細" + list.size()
						+ "筆同時被新增");
			
				// Handle any SQL errors
				} catch (SQLException se) {
					if (con != null) {
						try {
							// 3●設定於當有exception發生時之catch區塊內
							System.err.print("Transaction is being ");
							System.err.println("rolled back-由-dept");
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
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
		
		}
		
	
	//測試 同時新增訂單主檔及明細
//	public static void main(String[] args) {
//
//		OrderMainFileDAO dao = new OrderMainFileDAO();
//
//		OrderMainFileVO orderMainFileVO = new OrderMainFileVO();
//
//		orderMainFileVO.setMemberserialnumber(1636001);
//		orderMainFileVO.setSellerserialnumber(1000);
//		orderMainFileVO.setOrderstatusnumber("1");
//		orderMainFileVO.setCouponserialnumber(1);
//		orderMainFileVO.setSellerevaluationstar(3);
//		orderMainFileVO.setMemberevaluationstar(3);
//		orderMainFileVO.setSellerevaluationdescription("");
//		orderMainFileVO.setMemberevaluationdescription("");
//		orderMainFileVO.setOrderamount(5555555);
//		orderMainFileVO.setOrderdate(java.sql.Date.valueOf("2022-08-06"));
//		
//		
//		List<OrderDetailVO> testList = new ArrayList<OrderDetailVO>(); // 準備置入orderdetail筆數
//		OrderDetailVO odXX = new OrderDetailVO();   // orderdetail1
//		odXX.setItemserialnumber(87878701);
//		odXX.setOrderdetailprice(2000);
//		odXX.setOrderdetailquantity(2);
//		odXX.setRefundreason("");
//		odXX.setOrderdetailstatus(2);
//
//		OrderDetailVO odyy = new OrderDetailVO();   // orderdetail2
//		odyy.setItemserialnumber(87878702);
//		odyy.setOrderdetailprice(1000);
//		odyy.setOrderdetailquantity(1);
//		odyy.setRefundreason("");
//		odyy.setOrderdetailstatus(1);
//
//		testList.add(odXX);
//		testList.add(odyy);
//		
//		dao.insertWithOrderDetail(orderMainFileVO , testList);
		

		// 查詢所有訂單主檔
//		List<OrderMainFileVO> list = dao.getAll();
//		for (OrderMainFileVO aOrderMainFile : list) {
//			System.out.print(aOrderMainFile.getOrderserialnumber());
//			System.out.print(aOrderMainFile.getMemberserialnumber());
//			System.out.print(aOrderMainFile.getSellerserialnumber());
//			System.out.print(aOrderMainFile.getOrderstatusnumber());
//			System.out.print(aOrderMainFile.getCouponserialnumber());
//			System.out.print(aOrderMainFile.getSellerevaluationstar());
//			System.out.print(aOrderMainFile.getMemberevaluationstar());
//			System.out.print(aOrderMainFile.getSellerevaluationdescription());
//			System.out.print(aOrderMainFile.getMemberevaluationdescription());
////			System.out.print(aOrderMainFile.getMemberevaluationphoto());
//			System.out.print(aOrderMainFile.getOrderamount());
//			System.out.print(aOrderMainFile.getOrderdate());
//			System.out.println();
//		}
//	
//	}
	
//		@Override
//		public List<OrderMainFileVO> getAll() {
//			List<OrderMainFileVO> list = new ArrayList<OrderMainFileVO>();
//			OrderMainFileVO orderMainFileVO = null;
//
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//
//			try {
//
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(GET_ALL_STMT);
//				rs = pstmt.executeQuery();
//
//				while (rs.next()) {
//					// orderMainFileVO 也稱為 Domain objects
//					orderMainFileVO = new OrderMainFileVO();
//					orderMainFileVO.setOrderserialnumber(rs.getInt("order_serial_number"));
//					orderMainFileVO.setMemberserialnumber(rs.getInt("member_serial_number"));
//					orderMainFileVO.setSellerserialnumber(rs.getInt("seller_serial_number"));
//					orderMainFileVO.setOrderstatusnumber(rs.getString("order_status_number"));
//					orderMainFileVO.setCouponserialnumber(rs.getInt("coupon_serial_number"));
//					orderMainFileVO.setSellerevaluationstar(rs.getInt("seller_evaluation_star"));
//					orderMainFileVO.setMemberevaluationstar(rs.getInt("member_evaluation_star"));
//					orderMainFileVO.setSellerevaluationdescription(rs.getString("seller_evaluation_description"));
//					orderMainFileVO.setMemberevaluationdescription(rs.getString("member_evaluation_description"));
//					orderMainFileVO.setOrderamount(rs.getInt("order_amount"));
//					orderMainFileVO.setOrderdate(rs.getDate("order_date"));
//					list.add(orderMainFileVO); // Store the row in the list
//				}
//
//				// Handle any driver errors
//			} catch (SQLException se) {
//				throw new RuntimeException("A database error occured. "
//						+ se.getMessage());
//				// Clean up JDBC resources
//			} finally {
//				if (rs != null) {
//					try {
//						rs.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (pstmt != null) {
//					try {
//						pstmt.close();
//					} catch (SQLException se) {
//						se.printStackTrace(System.err);
//					}
//				}
//				if (con != null) {
//					try {
//						con.close();
//					} catch (Exception e) {
//						e.printStackTrace(System.err);
//					}
//				}
//			}
//			return list;
//		}
}