package com.frontpage_announcement.model;
import java.sql.Date;

public class Frontpage_announcement_VO implements java.io.Serializable{
	
	
	private Integer frontpage_announcement_serial_number;
	private Integer administrator_serial_number;
	private String frontpage_announcement_description;
	private Date frontpage_announcement_onload_date;
	private Date frontpage_announcement_offload_date;
	private Integer frontpage_announcement_status;
	
	public Integer getFrontpage_announcement_serial_number() {
		return frontpage_announcement_serial_number;
	}
	public void setFrontpage_announcement_serial_number(Integer frontpage_announcement_serial_number) {
		this.frontpage_announcement_serial_number = frontpage_announcement_serial_number;
	}
	public Integer getAdministrator_serial_number() {
		return administrator_serial_number;
	}
	public void setAdministrator_serial_number(Integer administrator_serial_number) {
		this.administrator_serial_number = administrator_serial_number;
	}
	public String getFrontpage_announcement_description() {
		return frontpage_announcement_description;
	}
	public void setFrontpage_announcement_description(String frontpage_announcement_description) {
		this.frontpage_announcement_description = frontpage_announcement_description;
	}
	public Date getFrontpage_announcement_onload_date() {
		return frontpage_announcement_onload_date;
	}
	public void setFrontpage_announcement_onload_date(Date frontpage_announcement_onload_date) {
		this.frontpage_announcement_onload_date = frontpage_announcement_onload_date;
	}
	public Date getFrontpage_announcement_offload_date() {
		return frontpage_announcement_offload_date;
	}
	public void setFrontpage_announcement_offload_date(Date frontpage_announcement_offload_date) {
		this.frontpage_announcement_offload_date = frontpage_announcement_offload_date;
	}
	public Integer getFrontpage_announcement_status() {
		return frontpage_announcement_status;
	}
	public void setFrontpage_announcement_status(Integer frontpage_announcement_status) {
		this.frontpage_announcement_status = frontpage_announcement_status;
	}



	

	
}
