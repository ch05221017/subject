package subject.blacklist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BlacklistJDBCDAO implements BlacklistDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/letitgo?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "aa128360877";

	private static final String INSERT_STMT = 
		"INSERT INTO black_list (seller_serial_number,member_serial_number,black_list_status) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT black_list_number,seller_serial_number,member_serial_number,black_list_status,member_account FROM black_list order by black_list_number";
	private static final String GET_ONE_STMT = 
		"SELECT black_list_number,seller_serial_number,member_serial_number,black_list_status FROM black_list where member_serial_number = ?";
/*新增*/	private static final String GET_ACCOUNT_STMT = 
		"select b.member_serial_number, b.black_list_number,m.member_account,b.seller_serial_number,b.black_list_status from	black_list b join member m on b.member_serial_number = m.member_serial_number where m.member_account = ?";
	private static final String DELETE = 
		"DELETE FROM black_list where black_list_number = ?";
	private static final String UPDATE = 
		"UPDATE black_list set seller_serial_number,member_serial_number,black_list_status where black_list_number = ?";
	private static final String GET_ALL_AND_ACCOUNT = 
			"select b.member_serial_number, b.black_list_number, m.member_account, b.seller_serial_number, b.black_list_status from black_list b join member m on b.member_serial_number = m.member_serial_number;";
	
	
	
	@Override
	public void insert(BlacklistVO blacklistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, blacklistVO.getSerialnumber());
			pstmt.setInt(2, blacklistVO.getMemberserialnumber());
			pstmt.setBoolean(3, blacklistVO.isBlackliststatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void update(BlacklistVO blacklistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, blacklistVO.getSerialnumber());
			pstmt.setInt(2, blacklistVO.getMemberserialnumber());
			pstmt.setBoolean(3, blacklistVO.isBlackliststatus());
			pstmt.setInt(4, blacklistVO.getBlacklistnumber());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(Integer blacklistnumber) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, blacklistnumber);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public BlacklistVO findMemberserialnumber(Integer memberserialnumber) {

		BlacklistVO blacklistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberserialnumber);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				blacklistVO = new BlacklistVO();
				blacklistVO.setBlacklistnumber(rs.getInt("blacklistnumber"));
				blacklistVO.setSerialnumber(rs.getInt("serialnumber"));
				blacklistVO.setMemberserialnumber(rs.getInt("memberserialnumber"));
				blacklistVO.setBlackliststatus(rs.getBoolean("blackliststatus"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
		return blacklistVO;
	}

	@Override
	public List<BlacklistVO> getAll() {
		List<BlacklistVO> list = new ArrayList<BlacklistVO>();
		BlacklistVO blacklistVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				blacklistVO = new BlacklistVO();
				blacklistVO.setBlacklistnumber(rs.getInt("blacklistnumber"));
				blacklistVO.setSerialnumber(rs.getInt("serialnumber"));
				blacklistVO.setMemberserialnumber(rs.getInt("memberserialnumber"));
				blacklistVO.setBlackliststatus(rs.getBoolean("blackliststatus"));
				list.add(blacklistVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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

	
	@Override
/*以下新增*/	public BlacklistVO findAccount(String account) {

		BlacklistVO blacklistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ACCOUNT_STMT);

			pstmt.setString(1, account);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				blacklistVO = new BlacklistVO();
				blacklistVO.setBlacklistnumber(rs.getInt("blacklistnumber"));
				blacklistVO.setSerialnumber(rs.getInt("serialnumber"));
				blacklistVO.setMemberserialnumber(rs.getInt("memberserialnumber"));
				blacklistVO.setBlackliststatus(rs.getBoolean("blackliststatus"));
				blacklistVO.setAccount(rs.getString("account"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
		return blacklistVO;
	}
	
	@Override
	public List<BlacklistVO> getAllAndAccount() {
		List<BlacklistVO> list = new ArrayList<BlacklistVO>();
		BlacklistVO blacklistVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_AND_ACCOUNT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				blacklistVO = new BlacklistVO();
				blacklistVO.setBlacklistnumber(rs.getInt("blacklistnumber"));
				blacklistVO.setSerialnumber(rs.getInt("serialnumber"));
				blacklistVO.setMemberserialnumber(rs.getInt("memberserialnumber"));
				blacklistVO.setBlackliststatus(rs.getBoolean("blackliststatus"));
				blacklistVO.setAccount(rs.getString("account"));
				list.add(blacklistVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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

		BlacklistJDBCDAO dao = new BlacklistJDBCDAO();

		// 新增
		BlacklistVO blacklistVO1 = new BlacklistVO();
		blacklistVO1.setSerialnumber(1000);
		blacklistVO1.setMemberserialnumber(1636001);
		blacklistVO1.setBlackliststatus(true);
		blacklistVO1.setAccount("abc002");
		dao.insert(blacklistVO1);

		// 修改
		BlacklistVO blacklistVO2 = new BlacklistVO();
		blacklistVO2.setBlacklistnumber(1);
		blacklistVO2.setSerialnumber(1000);
		blacklistVO2.setMemberserialnumber(1636002);
		blacklistVO2.setBlackliststatus(true);
		blacklistVO2.setAccount("abc002");
		dao.update(blacklistVO2);

		// 刪除
		dao.delete(1636001);

		// 查詢
		BlacklistVO blacklistVO3 = dao.findMemberserialnumber(1636001);
		System.out.print(blacklistVO3.getBlacklistnumber() + ",");
		System.out.print(blacklistVO3.getSerialnumber() + ",");
		System.out.print(blacklistVO3.getMemberserialnumber() + ",");
		System.out.print(blacklistVO3.isBlackliststatus() + ",");
		System.out.println(blacklistVO3.getAccount()+",");  //新增
		System.out.println("---------------------");

		// 查詢
		List<BlacklistVO> list = dao.getAll();
		for (BlacklistVO xblacklist : list) {
			System.out.print(xblacklist.getBlacklistnumber() + ",");
			System.out.print(xblacklist.getSerialnumber() + ",");
			System.out.print(xblacklist.getMemberserialnumber() + ",");
			System.out.print(xblacklist.isBlackliststatus() + ",");
			System.out.println(xblacklist.getAccount() + ",");  //新增
			System.out.println();
		}
	}
}
