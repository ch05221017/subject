package subject.vo;

import java.sql.Date;

public class FroannVO implements java.io.Serializable {
	private Integer froannno;
	private Integer admno;
	private String  froanndesc;
	private Date	froannsdate;
	private Date	froannedate;
	private Integer	froannstatus;
	private Integer admid;
	private String admname;	
	
	@Override
	public String toString() {
		return "FroannVO [froannno=" + froannno + ", admno=" + admno + ", froanndesc=" + froanndesc + ", froannsdate="
				+ froannsdate + ", froannedate=" + froannedate + ", froannstatus=" + froannstatus + ", admid=" + admid
				+ ", admname=" + admname + "]";
	}
	public Integer getFroannno() {
		return froannno;
	}
	public void setFroannno(Integer froannno) {
		this.froannno = froannno;
	}
	public Integer getAdmno() {
		return admno;
	}
	public void setAdmno(Integer admno) {
		this.admno = admno;
	}
	public String getFroanndesc() {
		return froanndesc;
	}
	public void setFroanndesc(String froanndesc) {
		this.froanndesc = froanndesc;
	}
	public Date getFroannsdate() {
		return froannsdate;
	}
	public void setFroannsdate(Date froannsdate) {
		this.froannsdate = froannsdate;
	}
	public Date getFroannedate() {
		return froannedate;
	}
	public void setFroannedate(Date froannedate) {
		this.froannedate = froannedate;
	}
	public Integer getFroannstatus() {
		return froannstatus;
	}
	public void setFroannstatus(Integer froannstatus) {
		this.froannstatus = froannstatus;
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
		
}
