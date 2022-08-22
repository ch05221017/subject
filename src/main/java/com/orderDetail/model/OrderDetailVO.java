package com.orderDetail.model;

import java.io.Serializable;

public class OrderDetailVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderdetailserialnumber;
	private Integer orderserialnumber;
	private Integer itemserialnumber;
	private Integer orderdetailprice;
	private Integer orderdetailquantity;
	private String refundreason;
	private Integer orderdetailstatus;
	
	//FK item
	private String itemname;
	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	//FK photo
	private byte[] photo;
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Integer getOrderdetailserialnumber() {
		return orderdetailserialnumber;
	}

	public void setOrderdetailserialnumber(Integer orderdetailserialnumber) {
		this.orderdetailserialnumber = orderdetailserialnumber;
	}

	public Integer getOrderserialnumber() {
		return orderserialnumber;
	}

	public void setOrderserialnumber(Integer orderserialnumber) {
		this.orderserialnumber = orderserialnumber;
	}

	public Integer getItemserialnumber() {
		return itemserialnumber;
	}

	public void setItemserialnumber(Integer itemserialnumber) {
		this.itemserialnumber = itemserialnumber;
	}

	public Integer getOrderdetailprice() {
		return orderdetailprice;
	}

	public void setOrderdetailprice(Integer orderdetailprice) {
		this.orderdetailprice = orderdetailprice;
	}

	public Integer getOrderdetailquantity() {
		return orderdetailquantity;
	}

	public void setOrderdetailquantity(Integer orderdetailquantity) {
		this.orderdetailquantity = orderdetailquantity;
	}

	public String getRefundreason() {
		return refundreason;
	}

	public void setRefundreason(String refundreason) {
		this.refundreason = refundreason;
	}

	public Integer getOrderdetailstatus() {
		return orderdetailstatus;
	}

	public void setOrderdetailstatus(Integer orderdetailstatus) {
		this.orderdetailstatus = orderdetailstatus;
	}
}
