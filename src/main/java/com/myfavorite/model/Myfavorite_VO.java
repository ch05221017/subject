package com.myfavorite.model;
import java.sql.Date;

public class Myfavorite_VO implements java.io.Serializable{
	private Integer my_favorite_number;
	private Integer item_serial_number;
	private Integer member_serial_number;
	public Integer getMy_favorite_number() {
		return my_favorite_number;
	}
	public void setMy_favorite_number(Integer my_favorite_number) {
		this.my_favorite_number = my_favorite_number;
	}
	public Integer getItem_serial_number() {
		return item_serial_number;
	}
	public void setItem_serial_number(Integer item_serial_number) {
		this.item_serial_number = item_serial_number;
	}
	public Integer getMember_serial_number() {
		return member_serial_number;
	}
	public void setMember_serial_number(Integer member_serial_number) {
		this.member_serial_number = member_serial_number;
	}


	
}
