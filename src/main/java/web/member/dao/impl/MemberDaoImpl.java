package web.member.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.member.dao.MemberDao;
import web.vo.Member;

public class MemberDaoImpl implements MemberDao {

	private DataSource dataSource;

	public MemberDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQL");
	}

	final String INSERT = "insert into MEMBER(MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_BIRTHDAY, MEMBER_EMAIL,"
			+ " MEMBER_PHONE_NUMBER, MEMBER_ADDRESS) " + "values(?, ?, ?, ?, ?, ?, ?)";
	// 註冊新增會員

	@Override
	public Integer insert(Member member) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(INSERT);) {
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getAddress());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String DELETE = "delete from MEMBER where MEMBER_SERIAL_NUMBER = ?;";

	@Override
	public Integer delete(Member member) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setInt(1, member.getMemberserialnumber());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	final String UPDATEPASSWORD = "update MEMBER set MEMBER_PASSWORD = ? where MEMBER_ACCOUNT = ?";
	@Override
	public Integer updatePassword(Member member) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement(UPDATEPASSWORD);){
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getAccount());
			
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	final String SELECTACCOUNT = "select MEMBER_SERIAL_NUMBER, MEMBER_ACCOUNT, MEMBER_PASSWORD from member where MEMBER_ACCOUNT = ?";

	
	@Override
	public Member selectAccount(Member member) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECTACCOUNT);) {
			System.out.println("testaccount");
			pstmt.setString(1, member.getAccount());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Member resultMember = new Member();
					resultMember.setMemberserialnumber(rs.getInt("MEMBER_SERIAL_NUMBER"));
					resultMember.setAccount(rs.getString("MEMBER_ACCOUNT"));
					resultMember.setPassword(rs.getString("MEMBER_PASSWORD"));
					System.out.println(resultMember);
					return resultMember;
				} else {
					
					System.out.println("rs is null");
					return null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return null");
		return null;
	}
	
	final String SELECTEMAIL = "select MEMBER_SERIAL_NUMBER, MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME, "
			+ "MEMBER_BIRTHDAY, MEMBER_ADDRESS, MEMBER_EMAIL, MEMBER_PHONE_NUMBER, MEMBER_STATUS, GOLD_REMAINING, "
			+ "MEMBER_EVALUATE_QUANTITY, MEMBER_EVALUATE_STARS from MEMBER where MEMBER_EMAIL = ?";

	// forgetpassword
	@Override
	public Member selectEmail(Member member) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECTEMAIL);) {
			System.out.println("TestMemberEmail: " + member.getEmail());
			pstmt.setString(1, member.getEmail());
			
			try (ResultSet rs = pstmt.executeQuery()) {
				System.out.println("TestMember");
				if (rs.next()) {
					Member resultMember = new Member();
					resultMember.setMemberserialnumber(rs.getInt("MEMBER_SERIAL_NUMBER"));
					resultMember.setAccount(rs.getString("MEMBER_ACCOUNT"));
					resultMember.setPassword(rs.getString("MEMBER_PASSWORD"));
					resultMember.setName(rs.getString("MEMBER_NAME"));
					resultMember.setBirthday(rs.getDate("MEMBER_BIRTHDAY"));
					resultMember.setAddress(rs.getString("MEMBER_ADDRESS"));
					resultMember.setEmail(rs.getString("MEMBER_EMAIL"));
					resultMember.setPhone(rs.getString("MEMBER_PHONE_NUMBER"));
					resultMember.setStatus(rs.getBoolean("MEMBER_STATUS"));
					resultMember.setGoldremaining(rs.getInt("GOLD_REMAINING"));
					resultMember.setQuantity(rs.getInt("MEMBER_EVALUATE_QUANTITY"));
					resultMember.setStars(rs.getInt("MEMBER_EVALUATE_STARS"));
					System.out.println(resultMember);
					return resultMember;
				} else {
					System.out.println("rs is Member null");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return Member null");
		return null;
	}

	final String SELECT = "select MEMBER_SERIAL_NUMBER, MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_BIRTHDAY, "
			+ "MEMBER_ADDRESS, MEMBER_EMAIL, MEMBER_PHONE_NUMBER, MEMBER_STATUS, GOLD_REMAINING, MEMBER_EVALUATE_QUANTITY, "
			+ "MEMBER_EVALUATE_STARS from MEMBER where MEMBER_ACCOUNT = ? and MEMBER_PASSWORD = ?";

	// Login
	@Override
	public Member selectForLogin(Member member) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT);) {
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getPassword());
			try (ResultSet rs = pstmt.executeQuery()) {
				System.out.println("Test1");
				if (rs.next()) {
					Member resultMember = new Member();
					resultMember.setMemberserialnumber(rs.getInt("MEMBER_SERIAL_NUMBER"));
					resultMember.setAccount(rs.getString("MEMBER_ACCOUNT"));
					resultMember.setPassword(rs.getString("MEMBER_PASSWORD"));
					resultMember.setName(rs.getString("MEMBER_NAME"));
					resultMember.setBirthday(rs.getDate("MEMBER_BIRTHDAY"));
					resultMember.setAddress(rs.getString("MEMBER_ADDRESS"));
					resultMember.setEmail(rs.getString("MEMBER_EMAIL"));
					resultMember.setPhone(rs.getString("MEMBER_PHONE_NUMBER"));
					resultMember.setStatus(rs.getBoolean("MEMBER_STATUS"));
					resultMember.setGoldremaining(rs.getInt("GOLD_REMAINING"));
					resultMember.setQuantity(rs.getInt("MEMBER_EVALUATE_QUANTITY"));
					resultMember.setStars(rs.getInt("MEMBER_EVALUATE_STARS"));
					System.out.println(resultMember);
					return resultMember;
				} else {
					System.out.println("rs is null");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return null");
		return null;
	}

}
