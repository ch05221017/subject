package com.advert.model;

import java.util.List;

public class advertService {
	private advertDAO_interface dao;

	public advertService() {
		dao = new advertDAO();
	}
	
	public advertVO getOneAdvert(Integer advertserialnumber) {
		return dao.findByPrimaryKey(advertserialnumber);
	}
	
	public advertVO getOneItem(Integer itemserialnumber) {
		return dao.findByItemPK(itemserialnumber);
	}

	public List<advertVO> getAll() {			
		return dao.getAll();
	}
	
	public advertVO add(Integer adminserialnumber,String advertdescription, byte[] advertphoto, Integer itemserialnumber) {
 
		advertVO advertvo = new advertVO();
		advertvo.setAdminserialnumber(adminserialnumber);
		advertvo.setAdvertdescription(advertdescription);
		advertvo.setAdvertphoto(advertphoto);
		advertvo.setItemserialnumber(itemserialnumber);
		dao.insert(advertvo);
		
		return advertvo;
	}
	
	public advertVO update(Integer advertserialnumber, Integer adminserialnumber, String advertdescription, byte[] advertphoto, Integer itemserialnumber) {

		advertVO advertvo = new advertVO();
		advertvo.setAdvertserialnumber(advertserialnumber);
		advertvo.setAdminserialnumber(adminserialnumber);
		advertvo.setAdvertdescription(advertdescription);
		advertvo.setAdvertphoto(advertphoto);
		advertvo.setItemserialnumber(itemserialnumber);		
		dao.update(advertvo);
		
		return advertvo;
	}
	
	public void delete(Integer advertserialnumber) {
		dao.delete(advertserialnumber);
	}
}
