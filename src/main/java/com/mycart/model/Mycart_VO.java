package com.mycart.model;
import java.sql.Date;

public class Mycart_VO implements java.io.Serializable{
	
	
	private Integer cart_serial_number;
	private Integer member_serial_number;
	private Integer item_serial_number;
	private Integer non_member_serial_number;
	private Integer cart_item_quantity;


	
	
	public Integer getCart_serial_number() {
		return cart_serial_number;
	}
	public void setCart_serial_number(Integer cart_serial_number) {
		this.cart_serial_number = cart_serial_number;
	}
	public Integer getMember_serial_number() {
		return member_serial_number;
	}
	public void setMember_serial_number(Integer member_serial_number) {
		this.member_serial_number = member_serial_number;
	}
	public Integer getItem_serial_number() {
		return item_serial_number;
	}
	public void setItem_serial_number(Integer item_serial_number) {
		this.item_serial_number = item_serial_number;
	}
	public Integer getNon_member_serial_number() {
		return non_member_serial_number;
	}
	public void setNon_member_serial_number(Integer non_member_serial_number) {
		this.non_member_serial_number = non_member_serial_number;
	}
	public Integer getCart_item_quantity() {
		return cart_item_quantity;
	}
	public void setCart_item_quantity(Integer cart_item_quantity) {
		this.cart_item_quantity = cart_item_quantity;
	}



	
}
