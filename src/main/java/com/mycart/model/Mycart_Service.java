package com.mycart.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Mycart_Service {

	private Mycart_DAO_interface dao;

	public Mycart_Service() {
		dao = new Mycart_DAO();
	}

	public Mycart_VO addEmp( Integer member_serial_number,  Integer item_serial_number,  Integer non_member_serial_number,  Integer cart_item_quantity
			) {

		Mycart_VO Mycart_VO = new Mycart_VO();

//		Mycart_VO.setCart_serial_number(cart_serial_number);
		Mycart_VO.setMember_serial_number(member_serial_number);
		Mycart_VO.setItem_serial_number(item_serial_number);
		Mycart_VO.setNon_member_serial_number(non_member_serial_number);
		Mycart_VO.setCart_item_quantity(cart_item_quantity);
//		item_category_VO.setItem_category_area_name(item_category_area_name);
//		item_category_VO.setItem_category_detail_name(item_category_detail_name);
		dao.insert(Mycart_VO);

		return Mycart_VO;
	}

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

	public void DELETE(Integer cart_serial_number) {
		dao.delete(cart_serial_number);
	}

	public Mycart_VO getOneEmp(Integer cart_serial_number) {
		return dao.findByPrimaryKey(cart_serial_number);
	}

	public List<Mycart_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Mycart_VO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}
