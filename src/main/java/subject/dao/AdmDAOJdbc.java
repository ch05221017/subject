package subject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import subject.vo.AdmBean;

public class AdmDAOJdbc implements AdmDAO {
	private DataSource dataSource;
	public AdmDAOJdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_BY_admname = "select * from administrator where administrator_account=?";
	@Override
	public AdmBean select(String admname) {
		AdmBean result = null;
		if(admname!=null) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rset = null;
			try {
				//conn = DriverManager.getConnection(URL, USERNAME, admname);
				conn = dataSource.getConnection();
				stmt = conn.prepareStatement(SELECT_BY_admname);
				stmt.setString(1, admname);
				rset = stmt.executeQuery();
				if(rset.next()) {
					result = new AdmBean();
					result.setAdmid(rset.getInt("administrator_serial_number"));
					result.setAdmname(rset.getString("administrator_account"));
					result.setPassword(rset.getString("administrator_password"));					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rset!=null) {
					try {
						rset.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (stmt!=null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	private static final String UPDATE =
			"update administrator set admname=?, password=? where admid=?";
	@Override
	public boolean update(String admname, String password, Integer admid) {
		if(admid!=null) {
			try(
//				Connection conn = DriverManager.getConnection(URL, USERNAME, admname);
				Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE);) {			
				stmt.setString(1, admname);
				stmt.setString(2, password);				
				stmt.setInt(3, admid);
				
				int i = stmt.executeUpdate();
				if(i==1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(String admname, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
