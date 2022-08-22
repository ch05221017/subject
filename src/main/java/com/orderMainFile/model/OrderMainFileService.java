package com.orderMainFile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orderDetail.model.OrderDetailVO;

public class OrderMainFileService {

	private OrderMainFileDAO_interface dao;

	public OrderMainFileService() {
		dao = new OrderMainFileDAO();
	}
	
	// TODO 應該被移到context scope才對
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "已完成");
		return map;
	}
	
	// 新增
	public OrderMainFileVO addOrderMainFile(Integer memberserialnumber, Integer sellerserialnumber,
			String orderstatusnumber, Integer couponserialnumber, Integer sellerevaluationstar,
			Integer memberevaluationstar, String sellerevaluationdescription, String memberevaluationdescription, Integer orderamount, java.sql.Date orderdate) {
		OrderMainFileVO orderMainFileVO = new OrderMainFileVO();

		orderMainFileVO.setMemberserialnumber(memberserialnumber);
		orderMainFileVO.setSellerserialnumber(sellerserialnumber);
		orderMainFileVO.setOrderstatusnumber(orderstatusnumber);
		orderMainFileVO.setCouponserialnumber(couponserialnumber);
		orderMainFileVO.setSellerevaluationstar(sellerevaluationstar);
		orderMainFileVO.setMemberevaluationstar(memberevaluationstar);
		orderMainFileVO.setSellerevaluationdescription(sellerevaluationdescription);
		orderMainFileVO.setMemberevaluationdescription(memberevaluationdescription);
		orderMainFileVO.setOrderamount(orderamount);
		orderMainFileVO.setOrderdate(orderdate);
		dao.insert(orderMainFileVO);

		return orderMainFileVO;
	}
	
	// 修改
	public OrderMainFileVO updateOrderMainFile(Integer orderserialnumber, Integer memberserialnumber, Integer sellerserialnumber,
			String orderstatusnumber, Integer couponserialnumber, Integer sellerevaluationstar,
			Integer memberevaluationstar, String sellerevaluationdescription, String memberevaluationdescription, Integer orderamount, java.sql.Date orderdate) {
		OrderMainFileVO orderMainFileVO = new OrderMainFileVO();

		orderMainFileVO.setOrderserialnumber(orderserialnumber);
		orderMainFileVO.setMemberserialnumber(memberserialnumber);
		orderMainFileVO.setSellerserialnumber(sellerserialnumber);
		orderMainFileVO.setOrderstatusnumber(orderstatusnumber);
		orderMainFileVO.setCouponserialnumber(couponserialnumber);
		orderMainFileVO.setSellerevaluationstar(sellerevaluationstar);
		orderMainFileVO.setMemberevaluationstar(memberevaluationstar);
		orderMainFileVO.setSellerevaluationdescription(sellerevaluationdescription);
		orderMainFileVO.setMemberevaluationdescription(memberevaluationdescription);
		orderMainFileVO.setOrderamount(orderamount);
		orderMainFileVO.setOrderdate(orderdate);
		dao.update(orderMainFileVO);

		return orderMainFileVO;
	}

	// 刪除
	public void deleteOrderMainFile(Integer orderserialnumber) {
		dao.delete(orderserialnumber);
	}
	
	// 單筆查詢
	public OrderMainFileVO getOneOrderMainFile(Integer orderserialnumber) {
		return dao.findByOrderPK(orderserialnumber);
	}

	// 全部查詢
	public List<OrderMainFileVO> getAll() {
		return dao.getAll();
	}
	
	// 用訂單流水編號查訂單明細
	public List<OrderDetailVO> findByOrderDetail(Integer orderserialnumber){
		return dao.findByOrderDetail(orderserialnumber);
	}
	
	// 同時新增訂單主檔及訂單明細
	public void insertWithOrderDetail(OrderMainFileVO orderMainFileVO , List<OrderDetailVO> list) {
		
	}
}