package web.seller.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.seller.dao.SellerDao;
import web.vo.Seller;

public class SellerDaoImpl implements SellerDao {

	private DataSource dataSource;

	public SellerDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQL");
	}

	final String INSERT = "insert into Seller(COMPANY_MEMBER_ACCOUNT, COMPANY_MEMBER_PASSWORD, COMPANY_NAME, ID_NUMBER,"
			+ " SELLER_EMAIL, SELLER_PHONE_NUMBER, COMPANY_HOLDER, COMPANY_HOLDER_ID, SELLER_MAIN_ADDRESS, STORE_DESCRIPTION) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// 註冊新增廠商

	@Override
	public int insert(Seller seller) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(INSERT)) {
			pstmt.setString(1, seller.getAccount());
			pstmt.setString(2, seller.getPassword());
			pstmt.setString(3, seller.getName());
			pstmt.setString(4, seller.getIdnumber());
			pstmt.setString(5, seller.getEmail());
			pstmt.setString(6, seller.getPhone());
			pstmt.setString(7, seller.getHolder());
			pstmt.setString(8, seller.getHolderid());
			pstmt.setString(9, seller.getMainaddress());
			pstmt.setString(10, seller.getDescription());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String DELETE = "delete from MEMBER where SELLER_SERIAL_NUMBER = ?;";

	@Override
	public Integer delete(Seller seller) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(DELETE);) {
			pstmt.setInt(1, seller.getSerialnumber());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) deleted!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	final String UPDATEPASSWORD = "update SELLER set COMPANY_MEMBER_PASSWORD = ? where COMPANY_MEMBER_ACCOUNT = ?";

	@Override
	public Integer updatePassword(Seller seller) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATEPASSWORD);) {
			pstmt.setString(1, seller.getPassword());
			pstmt.setString(2, seller.getAccount());

			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");
			return rowCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	final String SELECTACCOUNT = "select SELLER_SERIAL_NUMBER, COMPANY_MEMBER_ACCOUNT, COMPANY_MEMBER_PASSWORD from SELLER where COMPANY_MEMBER_ACCOUNT = ? ";

	@Override
	public Seller selectAccount(Seller seller) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECTACCOUNT);) {
			System.out.println("testaccount");
			pstmt.setString(1, seller.getAccount());
			System.out.println("SellerAccount "+seller.getAccount());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Seller resultSeller = new Seller();
					resultSeller.setSerialnumber(rs.getInt("SELLER_SERIAL_NUMBER"));
					resultSeller.setAccount(rs.getString("COMPANY_MEMBER_ACCOUNT"));
					resultSeller.setPassword(rs.getString("COMPANY_MEMBER_PASSWORD"));
					System.out.println("resultSeller: "+resultSeller);
					return resultSeller;
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

	final String SELECTEMAIL = "select SELLER_SERIAL_NUMBER, COMPANY_MEMBER_ACCOUNT, COMPANY_MEMBER_PASSWORD, COMPANY_NAME, ID_NUMBER, SELLER_EMAIL,\r\n"
			+ "COMPANY_HOLDER, COMPANY_HOLDER_ID, SELLER_PHONE_NUMBER, SELLER_MAIN_ADDRESS, SELLER_BRANCH_ADDRESS, STORE_DESCRIPTION, ADMINISTRATOR_REVISE_DATE,\r\n"
			+ "SELLER_EVALUATE_QUANTITY, SELLER_EVALUATE_STARS from SELLER where SELLER_EMAIL = ? ";

	// forgetpassword
	@Override
	public Seller selectEmail(Seller seller) {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECTEMAIL);) {
			System.out.println("SellerEmail: " + seller.getEmail());
			pstmt.setString(1, seller.getEmail());

			try (ResultSet rs = pstmt.executeQuery()) {
				System.out.println("TestSeller");
				if (rs.next()) {
					Seller resultSeller = new Seller();
					resultSeller.setSerialnumber(rs.getInt("SELLER_SERIAL_NUMBER"));
					resultSeller.setAccount(rs.getString("COMPANY_MEMBER_ACCOUNT"));
					resultSeller.setPassword(rs.getString("COMPANY_MEMBER_PASSWORD"));
					resultSeller.setName(rs.getString("COMPANY_NAME"));
					resultSeller.setIdnumber(rs.getString("ID_NUMBER"));
					resultSeller.setEmail(rs.getString("SELLER_EMAIL"));
					resultSeller.setHolder(rs.getString("COMPANY_HOLDER"));
					resultSeller.setHolderid(rs.getString("COMPANY_HOLDER_ID"));
					resultSeller.setPhone(rs.getString("SELLER_PHONE_NUMBER"));
					resultSeller.setMainaddress(rs.getString("SELLER_MAIN_ADDRESS"));
					resultSeller.setBranchaddress(rs.getString("SELLER_BRANCH_ADDRESS"));
					resultSeller.setDescription(rs.getString("STORE_DESCRIPTION"));
					resultSeller.setRevisedate(rs.getDate("ADMINISTRATOR_REVISE_DATE"));
					resultSeller.setQuantity(rs.getInt("SELLER_EVALUATE_QUANTITY"));
					resultSeller.setStars(rs.getInt("SELLER_EVALUATE_STARS"));
					System.out.println(resultSeller);
					return resultSeller;
				} else {
					System.out.println("Seller rs is null");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Return Seller null");
		return null;
	}

	// Login

	final String SELECT = "select SELLER_SERIAL_NUMBER, COMPANY_MEMBER_ACCOUNT, COMPANY_MEMBER_PASSWORD, COMPANY_NAME, ID_NUMBER, SELLER_EMAIL,"
			+ " COMPANY_HOLDER, COMPANY_HOLDER_ID, SELLER_PHONE_NUMBER, SELLER_MAIN_ADDRESS, SELLER_BRANCH_ADDRESS, STORE_DESCRIPTION, ADMINISTRATOR_REVISE_DATE,"
			+ " SELLER_EVALUATE_QUANTITY, SELLER_EVALUATE_STARS from SELLER where COMPANY_MEMBER_ACCOUNT = ? and COMPANY_MEMBER_PASSWORD = ?";

	@Override
	public Seller selectForLogin(Seller seller) {
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT)) {
			pstmt.setString(1, seller.getAccount());
			pstmt.setString(2, seller.getPassword());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Seller resultSeller = new Seller();
					resultSeller.setSerialnumber(rs.getInt("SELLER_SERIAL_NUMBER"));
					resultSeller.setAccount(rs.getString("COMPANY_MEMBER_ACCOUNT"));
					resultSeller.setPassword(rs.getString("COMPANY_MEMBER_PASSWORD"));
					resultSeller.setName(rs.getString("COMPANY_NAME"));
					resultSeller.setIdnumber(rs.getString("ID_NUMBER"));
					resultSeller.setEmail(rs.getString("SELLER_EMAIL"));
					resultSeller.setHolder(rs.getString("COMPANY_HOLDER"));
					resultSeller.setHolderid(rs.getString("COMPANY_HOLDER_ID"));
					resultSeller.setPhone(rs.getString("SELLER_PHONE_NUMBER"));
					resultSeller.setMainaddress(rs.getString("SELLER_MAIN_ADDRESS"));
					resultSeller.setBranchaddress(rs.getString("SELLER_BRANCH_ADDRESS"));
					resultSeller.setDescription(rs.getString("STORE_DESCRIPTION"));
					resultSeller.setRevisedate(rs.getDate("ADMINISTRATOR_REVISE_DATE"));
					resultSeller.setQuantity(rs.getInt("SELLER_EVALUATE_QUANTITY"));
					resultSeller.setStars(rs.getInt("SELLER_EVALUATE_STARS"));
					return resultSeller;
				} else {
					System.out.println("rs is null");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}