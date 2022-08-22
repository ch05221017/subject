package subject.dao;

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

import subject.vo.CouponjspVO;


public class CouponjspJNDIDAO implements CouponjspDAO_interface {
	
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
			"INSERT INTO coupon (coupon_name,start_date,end_date,refund_percent) VALUES (?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT coupon_serial_number,coupon_name,start_date,end_date,refund_percent FROM coupon order by coupon_serial_number";
		private static final String GET_ONE_STMT = 
			"SELECT coupon_serial_number,coupon_name,start_date,end_date,refund_percent FROM coupon where coupon_serial_number = ?";
		private static final String DELETE = 
			"DELETE FROM coupon where coupon_serial_number = ?";
		private static final String UPDATE = 
			"UPDATE coupon set coupon_name=?, start_date=?, end_date=?, refund_percent=? where coupon_serial_number = ?";
			
		@Override
		public void insert(CouponjspVO couponjspVO) {

				Connection con = null;
				PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();
					pstmt = con.prepareStatement(INSERT_STMT);

					
					pstmt.setString(1, couponjspVO.getCouponname());
					pstmt.setDate(2,  couponjspVO.getStartdate());
					pstmt.setDate(3, couponjspVO.getEnddate());
					pstmt.setFloat(4, couponjspVO.getRefundpercent());

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
		public void update(CouponjspVO couponjspVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				
				pstmt.setString(1, couponjspVO.getCouponname());
				pstmt.setDate(2, couponjspVO.getStartdate());
				pstmt.setDate(3, couponjspVO.getEnddate());
				pstmt.setFloat(4, couponjspVO.getRefundpercent());					
				pstmt.setInt(5, couponjspVO.getCouponserialnumber());

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
		public void delete(Integer couponserialnumber) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, couponserialnumber);

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
		public CouponjspVO findByPrimaryKey(Integer couponserialnumber) {

			CouponjspVO couponjspVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, couponserialnumber);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// coupon 也稱為 Domain objects
					couponjspVO = new CouponjspVO();
					couponjspVO.setCouponserialnumber(rs.getInt("coupon_serial_number"));						
					couponjspVO.setCouponname(rs.getString("coupon_name"));
					couponjspVO.setStartdate(rs.getDate("start_date"));
					couponjspVO.setEnddate(rs.getDate("end_date"));
					couponjspVO.setRefundpercent(rs.getFloat("refund_percent"));						
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
			return couponjspVO;
		}

		@Override
		public List<CouponjspVO> getAll() {
			List<CouponjspVO> list = new ArrayList<CouponjspVO>();
			CouponjspVO couponjspVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// coupon 也稱為 Domain objects
					couponjspVO = new CouponjspVO();
					couponjspVO.setCouponserialnumber(rs.getInt("coupon_serial_number"));						
					couponjspVO.setCouponname(rs.getString("coupon_name"));
					couponjspVO.setStartdate(rs.getDate("start_date"));
					couponjspVO.setEnddate(rs.getDate("end_date"));
					couponjspVO.setRefundpercent(rs.getFloat("refund_percent"));						
					list.add(couponjspVO); // Store the row in the list
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
	}

