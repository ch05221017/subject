package com.advert.model;

import java.util.List;

public interface advertDAO_interface {

	public advertVO findByPrimaryKey(Integer advertserialnumber);

	public List<advertVO> getAll();

	public void insert(advertVO advertvo);

	public void update(advertVO advertvo);

	public void delete(Integer advertserialnumber);

	public advertVO findByItemPK(Integer itemserialnumber);
	
//	public advertVO findByItemPK(Integer itemserialnumber);

//	List<advertVO> getAdminaccount();

}
