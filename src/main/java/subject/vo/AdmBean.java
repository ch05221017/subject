package subject.vo;

import java.util.Arrays;

public class AdmBean {
	private Integer admid;
	private String admname;
	private String password;
	@Override
	public String toString() {
		return "AdmBean [admid=" + admid + ", admname=" + admname + ", password=" + password + "]";
	}
	public Integer getAdmid() {
		return admid;
	}
	public void setAdmid(Integer admid) {
		this.admid = admid;
	}
	public String getAdmname() {
		return admname;
	}
	public void setAdmname(String admname) {
		this.admname = admname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
