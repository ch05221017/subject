package subject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import subject.vo.FroannVO;

public class FroannJDBCDAO implements FroannDAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "password";
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
			"INSERT INTO frontpage_announcement (administrator_serial_number,frontpage_announcement_description,frontpage_announcement_onload_date,frontpage_announcement_offload_date,frontpage_announcement_status) VALUES (?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT frontpage_announcement_serial_number,administrator_serialnumber,frontpage_announcementde_scription,frontpage_announcement_onload_date,frontpage_announcement_offload_date,frontpage_announcement_status FROM frontpage_announcement order by frontpage_announcement_serial_number";
		private static final String GET_ONE_STMT = 
			"SELECT frontpage_announcement_serial_number,administrator_serialnumber,frontpage_announcementde_scription,frontpage_announcement_onload_date,frontpage_announcement_offload_date,frontpage_announcement_status FROM frontpage_announcement where frontpage_announcement_serial_number = ?";
		private static final String DELETE = 
			"DELETE FROM frontpage_announcement where frontpage_announcement_serial_number = ?";
		private static final String UPDATE = 
			"UPDATE frontpage_announcement set administrator_serial_number=?, frontpage_announcement_description=?, frontpage_announcement_onload_date=?, frontpage_announcement_offload_date=?, frontpage_announcement_status=? where frontpage_announcement_serial_number = ?";
	@Override
	public void insert(FroannVO froannVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, froannVO.getAdmno());
			pstmt.setString(2, froannVO.getFroanndesc());
			pstmt.setDate(3, froannVO.getFroannsdate());
			pstmt.setDate(4, froannVO.getFroannedate());
			pstmt.setInt(5, froannVO.getFroannstatus());			

			pstmt.executeUpdate();

			// Handle any driver errors
			
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
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
	public void update(FroannVO froannVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, froannVO.getAdmno());
			pstmt.setString(2, froannVO.getFroanndesc());
			pstmt.setDate(3, froannVO.getFroannsdate());
			pstmt.setDate(4, froannVO.getFroannedate());
			pstmt.setDouble(5, froannVO.getFroannstatus());		
			pstmt.setInt(7, froannVO.getFroannno());

			pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
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
	public void delete(Integer froannno) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, froannno);

			pstmt.executeUpdate();

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
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
	public FroannVO findByPrimaryKey(Integer froannno) {

		FroannVO froannVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, froannno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// froannVo 也稱為 Domain objects
				froannVO = new FroannVO();
				froannVO.setFroannno(rs.getInt("frontpage_announcement_serial_number"));
				froannVO.setAdmno(rs.getInt("administrator_serial_number"));
				froannVO.setFroanndesc(rs.getString("frontpage_announcement_description"));
				froannVO.setFroannsdate(rs.getDate("frontpage_announcement_onload_date"));
				froannVO.setFroannedate(rs.getDate("frontpage_announcement_offload_date"));
				froannVO.setFroannstatus(rs.getInt("frontpage_announcement_status"));	
				
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
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
		return froannVO;
	}

	@Override
	public List<FroannVO> getAll() {
		List<FroannVO> list = new ArrayList<FroannVO>();
		FroannVO froannVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// froannVO 也稱為 Domain objects
				froannVO = new FroannVO();
				froannVO.setFroannno(rs.getInt("frontpage_announcement_serial_number"));
				froannVO.setAdmno(rs.getInt("administrator_serial_number"));
				froannVO.setFroanndesc(rs.getString("frontpage_announcement_description"));
				froannVO.setFroannsdate(rs.getDate("frontpage_announcement_onload_date"));
				froannVO.setFroannedate(rs.getDate("frontpage_announcement_offload_date"));
				froannVO.setFroannstatus(rs.getInt("frontpage_announcement_status"));						
				list.add(froannVO); // Store the row in the list
			}

			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. "
//					+ e.getMessage());
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
		return list;
	}

	public static void main(String[] args) {

		FroannJDBCDAO dao = new FroannJDBCDAO();

		// 新增
		FroannVO froannVO1 = new FroannVO();
		froannVO1.setAdmno(1);
		froannVO1.setFroanndesc("MANAGER");
		froannVO1.setFroannsdate(java.sql.Date.valueOf("2022-01-01"));
		froannVO1.setFroannedate(java.sql.Date.valueOf("2022-01-01"));
		froannVO1.setFroannstatus(0);
		dao.insert(froannVO1);

		// 修改
		FroannVO froannVO2 = new FroannVO();
		froannVO2.setFroannno(7001);
		froannVO2.setAdmno(1);
		froannVO2.setFroanndesc("MANAGER2");
		froannVO2.setFroannsdate(java.sql.Date.valueOf("2022-01-01"));
		froannVO2.setFroannedate(java.sql.Date.valueOf("2022-01-01"));
		froannVO2.setFroannstatus(0);		
		dao.update(froannVO2);

		// 刪除
		dao.delete(7014);

		// 查詢
		FroannVO froannVO3 = dao.findByPrimaryKey(7001);
		System.out.print(froannVO3.getFroannno() + ",");
		System.out.print(froannVO3.getAdmno() + ",");
		System.out.print(froannVO3.getFroanndesc() + ",");
		System.out.print(froannVO3.getFroannsdate() + ",");
		System.out.print(froannVO3.getFroannedate() + ",");
		System.out.print(froannVO3.getFroannstatus() + ",");
		System.out.println("---------------------");

		// 查詢
		List<FroannVO> list = dao.getAll();
		for (FroannVO aFroann : list) {
			System.out.print(aFroann.getFroannno() + ",");
			System.out.print(aFroann.getAdmno() + ",");
			System.out.print(aFroann.getFroanndesc() + ",");
			System.out.print(aFroann.getFroannsdate() + ",");
			System.out.print(aFroann.getFroannedate() + ",");
			System.out.print(aFroann.getFroannstatus() + ",");			
			System.out.println();
		}
	}
}

