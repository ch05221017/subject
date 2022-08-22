package com.orderStatus.model;

import java.util.List;
import java.util.Set;
import com.orderMainFile.model.OrderMainFileVO;

public class OrderStatusService {

	private OrderStatusDAO_interface dao;

	public OrderStatusService() {
		dao = new OrderStatusDAO();
	}

	public List<OrderStatusVO> getAll() {
		return dao.getAll();
	}

	public OrderStatusVO getOneOrderstatusnumber(String orderstatusnumber) {
		return dao.findByPrimaryKey(orderstatusnumber);
	}

	public Set<OrderMainFileVO> getOrderMainFilesByOrderStatusNumber(String orderstatusnumber) {
		return dao.getOrderMainFilesByOrderStatusNumber(orderstatusnumber);
	}

	public void deleteDept(String orderstatusnumber) {
		dao.delete(orderstatusnumber);
	}
}
