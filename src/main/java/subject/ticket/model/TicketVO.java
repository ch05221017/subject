package subject.ticket.model;

import java.util.Date;

public class TicketVO {
	private Integer orderserialnumber;
	private Integer orderdetailserialnumber;
	private String itemname;
	private Date orderdate;
	private String orderstatusname;
	private Integer memberserialnumber;
	
	
	@Override
	public String toString() {
		return "TicketVO [orderserialnumber=" + orderserialnumber + ", orderdetailserialnumber="
				+ orderdetailserialnumber + ", itemname=" + itemname + ", orderdate=" + orderdate + ", orderstatusname="
				+ orderstatusname + ", memberserialnumber=" + memberserialnumber + "]";
	}


	public Integer getOrderserialnumber() {
		return orderserialnumber;
	}


	public void setOrderserialnumber(Integer orderserialnumber) {
		this.orderserialnumber = orderserialnumber;
	}


	public Integer getOrderdetailserialnumber() {
		return orderdetailserialnumber;
	}


	public void setOrderdetailserialnumber(Integer orderdetailserialnumber) {
		this.orderdetailserialnumber = orderdetailserialnumber;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public Date getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}


	public String getOrderstatusname() {
		return orderstatusname;
	}


	public void setOrderstatusname(String orderstatusname) {
		this.orderstatusname = orderstatusname;
	}


	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}


	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}

	
	
}
