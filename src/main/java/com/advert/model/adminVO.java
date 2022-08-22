package com.advert.model;

import java.io.Serializable;

public class adminVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer adminserialnumber;
	private String adminaccount;
	private String adminpassword;
	
	public adminVO() {
		
	}

	public Integer getAdminserialnumber() {
		return adminserialnumber;
	}

	public void setAdminserialnumber(Integer adminserialnumber) {
		this.adminserialnumber = adminserialnumber;
	}

	public String getAdminaccount() {
		return adminaccount;
	}

	public void setAdminaccount(String adminaccount) {
		this.adminaccount = adminaccount;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
}
