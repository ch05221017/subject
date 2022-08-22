package com.item_category.model;

import java.util.List;
import java.util.Map;

public class Item_category_Service {

	private Item_category_DAO_interface dao;

	public Item_category_Service() {
		dao = new Item_category_DAO();
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

	public Item_category_VO getOneEmp(Integer item_category_number) {
		return dao.findByPrimaryKey(item_category_number);
	}

	public List<Item_category_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Item_category_VO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}
