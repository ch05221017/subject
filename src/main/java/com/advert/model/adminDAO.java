package com.advert.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class adminDAO implements adminDAO_interface{

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
	
	private static final String GET_ALL_STMT = "SELECT administrator_serial_number , administrator_account, administrator_password FROM administrator";
	private static final String GET_AdvertByAdmin = 
			"SELECT advertisement_serial_number, administrator_serial_number, advertisement_description, advertisement_photo, item_serial_number from advertisement order by advertisement_serial_number;";
		
	@Override
	public Set<advertVO> getAdvertByAdmin(String adminserialnumber) {
		Set<advertVO> set = new LinkedHashSet<advertVO>();
		advertVO advertvo = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_AdvertByAdmin);
			pstmt.setString(1, adminserialnumber);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				advertvo = new advertVO();
				advertvo.setAdvertserialnumber(rs.getInt("advertisement_serial_number"));
				advertvo.setAdminserialnumber(rs.getInt("administrator_serial_number"));
				advertvo.setAdvertdescription(rs.getString("advertisement_description"));
				advertvo.setAdvertphoto(rs.getBytes("advertisement_photo"));
				advertvo.setItemserialnumber(rs.getInt("item_serial_number"));
				advertvo.setAdminaccount(rs.getString("administrator_account"));
				advertvo.setItemname(rs.getString("item_name"));
				set.add(advertvo); // Store the row in the vector
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return set;
	}
	
	@Override
	public List<adminVO> getAll() {
		List<adminVO> list = new ArrayList<adminVO>();
		adminVO adminvo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adminvo = new adminVO();
				adminvo.setAdminserialnumber(rs.getInt("administrator_serial_number"));
				adminvo.setAdminaccount(rs.getString("administrator_account"));
				adminvo.setAdminpassword(rs.getString("administrator_password"));
				list.add(adminvo); // Store the row in the list
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
