package subject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.vo.Seller;

public class SellerUpdateDaoImpl implements SellerUpdateDao {
	private DataSource dataSource;

	public SellerUpdateDaoImpl() throws NamingException {
		dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/MySQL");
	}

	final String UPDATE_SELLER = "UPDATE letitgo.seller set company_name=?, company_member_account=?, company_member_password=?, id_number=?, seller_email=?, company_holder=?, company_holder_id=?, seller_phone_number=?, seller_main_address=?, seller_branch_address=?, store_description=? where seller_serial_number = 1002";

	@Override
	public void updateseller(Seller seller) {

		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(UPDATE_SELLER)) {
			
			pstmt.setInt(1, seller.getSerialnumber());
			pstmt.setString(1, seller.getName());
			pstmt.setString(2, seller.getAccount());
			pstmt.setString(3, seller.getPassword());
			pstmt.setString(4, seller.getIdnumber());
			pstmt.setString(5, seller.getEmail());
			pstmt.setString(6, seller.getHolder());
			pstmt.setString(7, seller.getHolderid());
			pstmt.setString(8, seller.getPhone());
			pstmt.setString(9, seller.getMainaddress());
			pstmt.setString(10, seller.getBranchaddress());
			pstmt.setString(11, seller.getDescription());
			int rowCount = pstmt.executeUpdate();
			System.out.println(rowCount + " row(s) updated!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	final String SELECT_BY_ID ="SELECT SELLER_SERIAL_NUMBER, COMPANY_MEMBER_ACCOUNT, COMPANY_MEMBER_PASSWORD, COMPANY_NAME, ID_NUMBER, SELLER_EMAIL,COMPANY_HOLDER, COMPANY_HOLDER_ID, SELLER_PHONE_NUMBER, SELLER_MAIN_ADDRESS, SELLER_BRANCH_ADDRESS, STORE_DESCRIPTION from seller where seller_serial_number = ?";
	@Override
	public Seller selectByID(Integer serialnumber) {
		
		Seller seller = null;
		
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_ID)) {
			pstmt.setInt(1, serialnumber);
			
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
				
					return resultSeller;
				} else {
					System.out.println("沒抓到賣家資訊!");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
