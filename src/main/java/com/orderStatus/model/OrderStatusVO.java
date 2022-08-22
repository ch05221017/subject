package com.orderStatus.model;

import java.io.Serializable;

public class OrderStatusVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderstatusnumber;
	private String orderstatusname;
	
	public OrderStatusVO() {
	}

	public OrderStatusVO(String orderstatusnumber, String orderstatusname) {
		this.orderstatusnumber = orderstatusnumber;
		this.orderstatusname = orderstatusname;
	}

	public String getOrderstatusnumber() {
		return orderstatusnumber;
	}

	public void setOrderstatusnumber(String orderstatusnumber) {
		this.orderstatusnumber = orderstatusnumber;
	}

	public String getOrderstatusname() {
		return orderstatusname;
	}

	public void setOrderstatusname(String orderstatusname) {
		this.orderstatusname = orderstatusname;
	}
}
