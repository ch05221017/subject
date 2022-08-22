package com.advertisement_show.model;
import java.sql.Date;

public class Advertisement_show_VO implements java.io.Serializable{
	
	public Integer getAdvertisement_serial_number() {
		return advertisement_serial_number;
	}
	public void setAdvertisement_serial_number(Integer advertisement_serial_number) {
		this.advertisement_serial_number = advertisement_serial_number;
	}
	public Integer getAdministrator_serial_number() {
		return administrator_serial_number;
	}
	public void setAdministrator_serial_number(Integer administrator_serial_number) {
		this.administrator_serial_number = administrator_serial_number;
	}
	public String getAdvertisement_description() {
		return advertisement_description;
	}
	public void setAdvertisement_description(String advertisement_description) {
		this.advertisement_description = advertisement_description;
	}
	public byte[] getAdvertisement_photo() {
		return advertisement_photo;
	}
	public void setAdvertisement_photo(byte[] advertisement_photo) {
		this.advertisement_photo = advertisement_photo;
	}
	public String getUrl_column() {
		return url_column;
	}
	public void setUrl_column(String url_column) {
		this.url_column = url_column;
	}
	public Integer getItem_serial_number() {
		return item_serial_number;
	}
	public void setItem_serial_number(Integer item_serial_number) {
		this.item_serial_number = item_serial_number;
	}
	private Integer advertisement_serial_number;
	private Integer administrator_serial_number;
	private String advertisement_description;
	private byte[] advertisement_photo;
	private String url_column;
	private Integer item_serial_number;


	

	
}
