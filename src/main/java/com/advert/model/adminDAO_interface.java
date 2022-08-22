package com.advert.model;

import java.util.List;
import java.util.Set;

import com.orderMainFile.model.OrderMainFileVO;
import com.orderStatus.model.OrderStatusVO;

public interface adminDAO_interface {
	
	public Set<advertVO> getAdvertByAdmin(String adminserialnumber);
    public List<adminVO> getAll();
}
