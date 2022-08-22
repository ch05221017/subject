package com.orderMainFile.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

public class OrderMainFileVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderserialnumber;
	private Integer memberserialnumber;
	private Integer sellerserialnumber;
	private String orderstatusnumber;
	private Integer couponserialnumber;
	private Integer sellerevaluationstar;
	private Integer memberevaluationstar;
	private String sellerevaluationdescription;
	private String memberevaluationdescription;
	private Integer orderamount;
	private Date orderdate;
	
	// FK
	private String companyname;
	
	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	// FK
	private String couponname;

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}
	
	// FK
	private String memberaccount;
	

	public String getMemberaccount() {
		return memberaccount;
	}

	public void setMemberaccount(String memberaccount) {
		this.memberaccount = memberaccount;
	}
	
	

	public OrderMainFileVO() {
	}

	public Integer getOrderserialnumber() {
		return orderserialnumber;
	}

	public void setOrderserialnumber(Integer orderserialnumber) {
		this.orderserialnumber = orderserialnumber;
	}

	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}

	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}

	public Integer getSellerserialnumber() {
		return sellerserialnumber;
	}

	public void setSellerserialnumber(Integer sellerserialnumber) {
		this.sellerserialnumber = sellerserialnumber;
	}

	public String getOrderstatusnumber() {
		return orderstatusnumber;
	}

	public void setOrderstatusnumber(String orderstatusnumber) {
		this.orderstatusnumber = orderstatusnumber;
	}

	public Integer getCouponserialnumber() {
		return couponserialnumber;
	}

	public void setCouponserialnumber(Integer couponserialnumber) {
		this.couponserialnumber = couponserialnumber;
	}

	public Integer getSellerevaluationstar() {
		return sellerevaluationstar;
	}

	public void setSellerevaluationstar(Integer sellerevaluationstar) {
		this.sellerevaluationstar = sellerevaluationstar;
	}

	public Integer getMemberevaluationstar() {
		return memberevaluationstar;
	}

	public void setMemberevaluationstar(Integer memberevaluationstar) {
		this.memberevaluationstar = memberevaluationstar;
	}

	public String getSellerevaluationdescription() {
		return sellerevaluationdescription;
	}

	public void setSellerevaluationdescription(String sellerevaluationdescription) {
		this.sellerevaluationdescription = sellerevaluationdescription;
	}

	public String getMemberevaluationdescription() {
		return memberevaluationdescription;
	}

	public void setMemberevaluationdescription(String memberevaluationdescription) {
		this.memberevaluationdescription = memberevaluationdescription;
	}

	public Integer getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(Integer orderamount) {
		this.orderamount = orderamount;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
}