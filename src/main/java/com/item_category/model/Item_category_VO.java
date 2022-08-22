package com.item_category.model;
import java.sql.Date;

public class Item_category_VO implements java.io.Serializable{
	
	private Integer item_category_number;
	private String item_category_main_name;
//	private String item_category_area_name;
//	private String item_category_detail_name;

	
	public Integer getItem_category_number() {
		return item_category_number;
	}
	public void setItem_category_number(Integer item_category_number) {
		this.item_category_number = item_category_number;
	}
	public String getItem_category_main_name() {
		return item_category_main_name;
	}
	public void setItem_category_main_name(String item_category_main_name) {
		this.item_category_main_name = item_category_main_name;
	}
//	public String getItem_category_area_name() {
//		return item_category_area_name;
//	}
//	public void setItem_category_area_name(String item_category_area_name) {
//		this.item_category_area_name = item_category_area_name;
//	}
//	public String getItem_category_detail_name() {
//		return item_category_detail_name;
//	}
//	public void setItem_category_detail_name(String item_category_detail_name) {
//		this.item_category_detail_name = item_category_detail_name;
//	}
//	@Override
//	public String toString() {
//		return "EmpVO [item_category_number=" + item_category_number + ", item_category_main_name="
//				+ item_category_main_name + ", item_category_area_name=" + item_category_area_name
//				+ ", item_category_detail_name=" + item_category_detail_name + "]";
//	}

	
}
