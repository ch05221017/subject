package com.item.model;
import java.sql.Date;

public class Item_VO implements java.io.Serializable{
	
	private Integer item_serial_number;
	private String item_name;
	private String item_description;
	private Integer item_price;
	private Integer item_stock;
	private Integer seller_serial_number;
	private String item_category_number;
	private byte[] photo;
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public Integer getItem_serial_number() {
		return item_serial_number;
	}
	public void setItem_serial_number(Integer item_serial_number) {
		this.item_serial_number = item_serial_number;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public Integer getItem_price() {
		return item_price;
	}
	public void setItem_price(Integer item_price) {
		this.item_price = item_price;
	}
	public Integer getItem_stock() {
		return item_stock;
	}
	public void setItem_stock(Integer item_stock) {
		this.item_stock = item_stock;
	}
	public Integer getSeller_serial_number() {
		return seller_serial_number;
	}
	public void setSeller_serial_number(Integer seller_serial_number) {
		this.seller_serial_number = seller_serial_number;
	}
	public String getItem_category_number() {
		return item_category_number;
	}
	public void setItem_category_number(String item_category_number) {
		this.item_category_number = item_category_number;
	}

	
}
