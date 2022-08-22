package subject.vo;

public class BLMemberVO implements java.io.Serializable {
	private Integer blacklistid;
	private Integer sellerid;
	private String  sellername;
	private Integer memberid;
	private String  membername;
	private Integer memberstatus;
	private Integer admid;
	private String 	admname;
	
	@Override
	public String toString() {
		return "BLMemberVO [blacklistid=" + blacklistid + ", sellerid=" + sellerid + ", sellername=" + sellername
				+ ", memberid=" + memberid + ", membername=" + membername + ", memberstatus=" + memberstatus
				+ ", admid=" + admid + ", admname=" + admname + "]";
	}

	
	public Integer getBlacklistid() {
		return blacklistid;
	}

	public void setBlacklistid(Integer blacklistid) {
		this.blacklistid = blacklistid;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public Integer getMemberstatus() {
		return memberstatus;
	}

	public void setMemberstatus(Integer memberstatus) {
		this.memberstatus = memberstatus;
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
