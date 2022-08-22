package com.orderDetail.model;

import java.util.List;

import com.orderMainFile.model.OrderMainFileVO;

public class OrderDetailService {
	
	private OrderDetailDAO_interface dao;

	public OrderDetailService() {
		dao = new OrderDetailDAO();
	}
	
	// 新增
	public OrderDetailVO addOrderMainFile(Integer orderdetailserialnumber, Integer orderserialnumber, Integer itemserialnumber, 
			Integer orderdetailprice, Integer orderdetailquantity, String refundreason, Integer orderdetailstatus) {
		
		OrderDetailVO orderDetailVO = new OrderDetailVO();
		
		orderDetailVO.setOrderdetailserialnumber(orderdetailserialnumber);
		orderDetailVO.setOrderserialnumber(orderserialnumber);
		orderDetailVO.setItemserialnumber(itemserialnumber);
		orderDetailVO.setOrderdetailprice(orderdetailprice);
		orderDetailVO.setOrderdetailquantity(orderdetailquantity);
		orderDetailVO.setRefundreason(refundreason);
		orderDetailVO.setOrderdetailstatus(orderdetailstatus);
		dao.insert(orderDetailVO);
		
		return orderDetailVO;
	}
	
	// 修改
	public OrderDetailVO updateOrderDetail(Integer orderdetailserialnumber, Integer orderserialnumber, Integer itemserialnumber, 
			Integer orderdetailprice, Integer orderdetailquantity, String refundreason, Integer orderdetailstatus) {

		OrderDetailVO orderDetailVO = new OrderDetailVO();
		
		orderDetailVO.setOrderdetailserialnumber(orderdetailserialnumber);
		orderDetailVO.setOrderserialnumber(orderserialnumber);
		orderDetailVO.setItemserialnumber(itemserialnumber);
		orderDetailVO.setOrderdetailprice(orderdetailprice);
		orderDetailVO.setOrderdetailquantity(orderdetailquantity);
		orderDetailVO.setRefundreason(refundreason);
		orderDetailVO.setOrderdetailstatus(orderdetailstatus);
		
		dao.update(orderDetailVO);
		return orderDetailVO;
		
	}
		
	// 刪除
	public void deleteOrderDetail(Integer orderdetailserialnumber) {
		dao.delete(orderdetailserialnumber);
	}
		
	// 單筆查詢
	public OrderDetailVO getOneOrderDetail(Integer orderdetailserialnumber) {
		return dao.findByOrderDetailPK(orderdetailserialnumber);
	}
		
	// 全部查詢
	public List<OrderDetailVO> getAllOrderDetail() {
		return dao.getAllOrderDetail();
	}
	
}