package com.advert.model;

import java.util.List;
import java.util.Set;

public class adminService {
	private adminDAO_interface dao;

	public adminService() {
		dao = new adminDAO();
	}
	public Set<advertVO> getAdvertByAdmin(String adminserialnumber) {
		return dao.getAdvertByAdmin(adminserialnumber);
	}
	
	public List<adminVO> getAll() {
		return dao.getAll();
	}
}
