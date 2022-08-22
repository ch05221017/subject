package com.order_detail.model;

import java.util.List;
import java.util.Map;

public class Order_detail_Service {

	private Order_detail_DAO_interface dao;

	public Order_detail_Service() {
		dao = new Order_detail_DAO();
	}

//	public Item_category_VO addEmp(String item_category_main_name, String item_category_area_name, String item_category_detail_name
//			) {
//
//		Item_category_VO item_category_VO = new Item_category_VO();
//
//		item_category_VO.setItem_category_main_name(item_category_main_name);
////		item_category_VO.setItem_category_area_name(item_category_area_name);
////		item_category_VO.setItem_category_detail_name(item_category_detail_name);
//		dao.insert(item_category_VO);
//
//		return item_category_VO;
//	}

//	public Item_category_VO updateEmp(String item_category_main_name, String item_category_area_name, String item_category_detail_name
//			) {
//
//		Item_category_VO Item_category_VO = new Item_category_VO();
//
//		Item_category_VO.setItem_category_main_name(item_category_main_name);
////		Item_category_VO.setItem_category_area_name(item_category_area_name);
////		Item_category_VO.setItem_category_detail_name(item_category_detail_name);
//		dao.update(Item_category_VO);
//
//		return Item_category_VO;
//	}

//	public void deleteEmp(Integer item_category_number) {
//		dao.delete(item_category_number);
//	}

	public Order_detail_VO getOneEmp(Integer order_detail_serial_number) {
		return dao.findByPrimaryKey(order_detail_serial_number);
	}

	public List<Order_detail_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Order_detail_VO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}
