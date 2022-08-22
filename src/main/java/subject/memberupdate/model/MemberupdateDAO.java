package subject.memberupdate.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberupdateDAO implements MemberupdateDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String GET_ALL_STMT = 
			"SELECT member_serial_number,member_name,member_address,member_email,member_phone_number FROM member order by member_serial_number";
	private static final String UPDATE = 
			"UPDATE member set member_name=?, member_address=?, member_email=?, member_phone_number=? where member_serial_number = ?";
	private static final String GET_ONE_STMT = 
			"SELECT member_serial_number,member_name,member_address,member_email,member_phone_number FROM member where member_serial_number = ?";

	@Override
	public void update(MemberupdateVO memberupdateVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memberupdateVO.getName());
			pstmt.setString(2, memberupdateVO.getAddress());
			pstmt.setString(3, memberupdateVO.getEmail());
			pstmt.setString(4, memberupdateVO.getPhone());
			pstmt.setInt(5, memberupdateVO.getMemberserialnumber());

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
	public MemberupdateVO findByPrimaryKey(Integer memberserialnumber) {

		MemberupdateVO memberupdateVO = null;
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
				memberupdateVO = new MemberupdateVO();
				memberupdateVO.setMemberserialnumber(rs.getInt("member_serial_number"));
				memberupdateVO.setName(rs.getString("member_name"));
				memberupdateVO.setAddress(rs.getString("member_address"));
				memberupdateVO.setEmail(rs.getString("member_email"));
				memberupdateVO.setPhone(rs.getString("member_phone_number"));
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
		return memberupdateVO;
	}

	@Override
	public List<MemberupdateVO> getAll() {
		List<MemberupdateVO> list = new ArrayList<MemberupdateVO>();
		MemberupdateVO memberupdateVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				memberupdateVO = new MemberupdateVO();
				memberupdateVO.setMemberserialnumber(rs.getInt("member_serial_number"));
				memberupdateVO.setName(rs.getString("member_name"));
				memberupdateVO.setAddress(rs.getString("member_address"));
				memberupdateVO.setEmail(rs.getString("member_email"));
				memberupdateVO.setPhone(rs.getString("member_phone_number"));
				list.add(memberupdateVO); // Store the row in the list
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