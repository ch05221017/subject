package com.product_seller.model;
import java.sql.Date;

public class Product_seller_VO implements java.io.Serializable{
	
	private Integer seller_serial_number;
	private String company_name;
	private String company_member_account;
	private String company_member_password;
	private String id_number;
	private String seller_email;
	private String company_holder;
	private String company_holder_id;
	private String seller_phone_number;
	private String seller_main_address;
	private String seller_branch_address;
	private String store_description;
	private Date administrator_revise_date;
	private Integer seller_evaluate_quantity;
	private Integer seller_evaluate_stars;
	
	public Integer getSeller_serial_number() {
		return seller_serial_number;
	}
	public void setSeller_serial_number(Integer seller_serial_number) {
		this.seller_serial_number = seller_serial_number;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_member_account() {
		return company_member_account;
	}
	public void setCompany_member_account(String company_member_account) {
		this.company_member_account = company_member_account;
	}
	public String getCompany_member_password() {
		return company_member_password;
	}
	public void setCompany_member_password(String company_member_password) {
		this.company_member_password = company_member_password;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getCompany_holder() {
		return company_holder;
	}
	public void setCompany_holder(String company_holder) {
		this.company_holder = company_holder;
	}
	public String getCompany_holder_id() {
		return company_holder_id;
	}
	public void setCompany_holder_id(String company_holder_id) {
		this.company_holder_id = company_holder_id;
	}
	public String getSeller_phone_number() {
		return seller_phone_number;
	}
	public void setSeller_phone_number(String seller_phone_number) {
		this.seller_phone_number = seller_phone_number;
	}
	public String getSeller_main_address() {
		return seller_main_address;
	}
	public void setSeller_main_address(String seller_main_address) {
		this.seller_main_address = seller_main_address;
	}
	public String getSeller_branch_address() {
		return seller_branch_address;
	}
	public void setSeller_branch_address(String seller_branch_address) {
		this.seller_branch_address = seller_branch_address;
	}
	public String getStore_description() {
		return store_description;
	}
	public void setStore_description(String store_description) {
		this.store_description = store_description;
	}
	public Date getAdministrator_revise_date() {
		return administrator_revise_date;
	}
	public void setAdministrator_revise_date(Date administrator_revise_date) {
		this.administrator_revise_date = administrator_revise_date;
	}
	public Integer getSeller_evaluate_quantity() {
		return seller_evaluate_quantity;
	}
	public void setSeller_evaluate_quantity(Integer seller_evaluate_quantity) {
		this.seller_evaluate_quantity = seller_evaluate_quantity;
	}
	public Integer getSeller_evaluate_stars() {
		return seller_evaluate_stars;
	}
	public void setSeller_evaluate_stars(Integer seller_evaluate_stars) {
		this.seller_evaluate_stars = seller_evaluate_stars;
	}

	

	
}
