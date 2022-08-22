package com.order_detail.model;
import java.sql.Date;

public class Order_detail_VO implements java.io.Serializable{
	
	
	private Integer order_detail_serial_number;
	private Integer order_serial_number;
	private Integer item_serial_number;
	private Integer order_detail_price;
	private Integer order_detail_quantity;
	private String refund_reason;
	private Integer order_detail_status;
	
	public Integer getOrder_detail_serial_number() {
		return order_detail_serial_number;
	}
	public void setOrder_detail_serial_number(Integer order_detail_serial_number) {
		this.order_detail_serial_number = order_detail_serial_number;
	}
	public Integer getOrder_serial_number() {
		return order_serial_number;
	}
	public void setOrder_serial_number(Integer order_serial_number) {
		this.order_serial_number = order_serial_number;
	}
	public Integer getItem_serial_number() {
		return item_serial_number;
	}
	public void setItem_serial_number(Integer item_serial_number) {
		this.item_serial_number = item_serial_number;
	}
	public Integer getOrder_detail_price() {
		return order_detail_price;
	}
	public void setOrder_detail_price(Integer order_detail_price) {
		this.order_detail_price = order_detail_price;
	}
	public Integer getOrder_detail_quantity() {
		return order_detail_quantity;
	}
	public void setOrder_detail_quantity(Integer order_detail_quantity) {
		this.order_detail_quantity = order_detail_quantity;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public Integer getOrder_detail_status() {
		return order_detail_status;
	}
	public void setOrder_detail_status(Integer order_detail_status) {
		this.order_detail_status = order_detail_status;
	}




	
}
