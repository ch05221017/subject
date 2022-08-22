package subject.blacklist.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BlacklistJNDIDAO implements BlacklistDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/letitgo");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

		private static final String INSERT_STMT = 
			"INSERT INTO black_list (seller_serial_number,member_serial_number,black_list_status) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT black_list_number,seller_serial_number,member_serial_number,black_list_status,member_account FROM black_list order by black_list_number";
		private static final String GET_ONE_STMT = 
			"SELECT black_list_number,seller_serial_number,member_serial_number,black_list_status FROM black_list where black_list_number = ?";
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, blacklistVO.getSerialnumber());
			pstmt.setInt(2, blacklistVO.getMemberserialnumber());
			pstmt.setBoolean(3, blacklistVO.isBlackliststatus());

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
	public void update(BlacklistVO blacklistVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, blacklistVO.getSerialnumber());
			pstmt.setInt(2, blacklistVO.getMemberserialnumber());
			pstmt.setBoolean(3, blacklistVO.isBlackliststatus());
			pstmt.setInt(4, blacklistVO.getBlacklistnumber());

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
	public void delete(Integer blacklistnumber) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, blacklistnumber);

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
	public BlacklistVO findMemberserialnumber(Integer memberserialnumber) {

		BlacklistVO blacklistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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
	public BlacklistVO findAccount(String account) {

		BlacklistVO blacklistVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
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
	public List<BlacklistVO> getAllAndAccount() {
		List<BlacklistVO> list = new ArrayList<BlacklistVO>();
		BlacklistVO blacklistVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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
