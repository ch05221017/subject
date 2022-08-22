package com.orderStatus.model;

import java.util.List;
import java.util.Set;

import com.orderMainFile.model.OrderMainFileVO;

public interface OrderStatusDAO_interface {
	    public void insert(OrderStatusVO orderStatusVO);
	    public void update(OrderStatusVO orderStatusVO);
	    public void delete(String orderstatusnumber);
	    public OrderStatusVO findByPrimaryKey(String orderstatusnumber);
	    public List<OrderStatusVO> getAll();
	    //查詢某部門的員工(一對多)(回傳 Set)
	    public Set<OrderMainFileVO> getOrderMainFilesByOrderStatusNumber(String orderstatusnumber);
}