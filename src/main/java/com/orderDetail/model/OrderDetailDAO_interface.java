package com.orderDetail.model;

import java.sql.Connection;
import java.util.List;

public interface OrderDetailDAO_interface {
	
		public void insert(OrderDetailVO orderDetailVO);
		public void update(OrderDetailVO orderDetailVO);
		public void delete(Integer orderdetailserialnumber);
		public OrderDetailVO findByOrderDetailPK(Integer itemserialnumber);
		public List<OrderDetailVO> getAllOrderDetail();
		
		//同時新增訂單主檔與明細
		public void insert2(OrderDetailVO orderDetailVO, Connection con);

}
