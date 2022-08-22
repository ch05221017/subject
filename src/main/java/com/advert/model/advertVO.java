package com.advert.model;

import java.io.Serializable;

public class advertVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer advertserialnumber;
	private Integer adminserialnumber;
	private String advertdescription;
	private byte[] advertphoto;
	private Integer itemserialnumber;
	
	//FK
	private String adminaccount;
	
	public String getAdminaccount() {
		return adminaccount;
	}

	public void setAdminaccount(String adminaccount) {
		this.adminaccount = adminaccount;
	}
	
	//FK
	private String itemname;

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	//FK
	private byte[] photo;

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	//FK
	private Integer sellerserialnumber;

	public Integer getSellerserialnumber() {
		return sellerserialnumber;
	}

	public void setSellerserialnumber(Integer sellerserialnumber) {
		this.sellerserialnumber = sellerserialnumber;
	}
	
	//FK
	private String companyaccount;

	public String getCompanyaccount() {
		return companyaccount;
	}

	public void setCompanyaccount(String companyaccount) {
		this.companyaccount = companyaccount;
	}

	public advertVO() {

	}
	
	public Integer getAdvertserialnumber() {
		return advertserialnumber;
	}

	public void setAdvertserialnumber(Integer advertserialnumber) {
		this.advertserialnumber = advertserialnumber;
	}

	public Integer getAdminserialnumber() {
		return adminserialnumber;
	}

	public void setAdminserialnumber(Integer adminserialnumber) {
		this.adminserialnumber = adminserialnumber;
	}

	public String getAdvertdescription() {
		return advertdescription;
	}

	public void setAdvertdescription(String advertdescription) {
		this.advertdescription = advertdescription;
	}

	public byte[] getAdvertphoto() {
		return advertphoto;
	}

	public void setAdvertphoto(byte[] advertphoto) {
		this.advertphoto = advertphoto;
	}

	public Integer getItemserialnumber() {
		return itemserialnumber;
	}

	public void setItemserialnumber(Integer itemserialnumber) {
		this.itemserialnumber = itemserialnumber;
	}
	
}
