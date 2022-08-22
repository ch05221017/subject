package subject.blacklist.model;

public class BlacklistVO {
	private Integer blacklistnumber;
	private Integer serialnumber;
	private Integer memberserialnumber;
	private boolean blackliststatus;
	private String account;//新增

	

	@Override
	public String toString() {
		return "BlacklistVO [blacklistnumber=" + blacklistnumber + ", serialnumber=" + serialnumber
				+ ", memberserialnumber=" + memberserialnumber + ", blackliststatus=" + blackliststatus + ", account="
				+ account + "]";
	}



	public Integer getBlacklistnumber() {
		return blacklistnumber;
	}



	public void setBlacklistnumber(Integer blacklistnumber) {
		this.blacklistnumber = blacklistnumber;
	}



	public Integer getSerialnumber() {
		return serialnumber;
	}



	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}



	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}



	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}



	public boolean isBlackliststatus() {
		return blackliststatus;
	}



	public void setBlackliststatus(boolean blackliststatus) {
		this.blackliststatus = blackliststatus;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}

	

}
