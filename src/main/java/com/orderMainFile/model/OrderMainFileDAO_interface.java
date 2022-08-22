package com.orderMainFile.model;

import java.util.List;

import com.orderDetail.model.OrderDetailVO;

public interface OrderMainFileDAO_interface {
	
		public void insert(OrderMainFileVO orderMainFileVO);
		public void update(OrderMainFileVO orderMainFileVO);
		public void delete(Integer orderserialnumber);
		public OrderMainFileVO findByOrderPK(Integer orderserialnumber);
		public List<OrderDetailVO> findByOrderDetail(Integer orderserialnumber);
		
		//get賣場名稱、優惠券名稱、會員帳號、會員帳號
		public List<OrderMainFileVO> getAll();
		
		// Mail發送
		Integer getOrderMail();
		
		// 同時新增訂單主檔及訂單明細
		void insertWithOrderDetail(OrderMainFileVO orderMainFileVO, List<OrderDetailVO> list);
}
