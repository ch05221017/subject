package com.myfavorite.model;

import java.util.List;
import java.util.Map;

public class Myfavorite_Service {

	private Myfavorite_DAO_interface dao;

	public Myfavorite_Service() {
		dao = new Myfavorite_DAO();
	}

	public Myfavorite_VO addEmp(Integer item_serial_number, Integer member_serial_number
			) {

		Myfavorite_VO Myfavorite_VO = new Myfavorite_VO();

		Myfavorite_VO.setItem_serial_number(item_serial_number);
		Myfavorite_VO.setMember_serial_number(member_serial_number);
//		item_category_VO.setItem_category_area_name(item_category_area_name);
//		item_category_VO.setItem_category_detail_name(item_category_detail_name);
		dao.insert(Myfavorite_VO);

		return Myfavorite_VO;
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

	public void DELETE(Integer my_favorite_number) {
		dao.delete(my_favorite_number);
	}

	public Myfavorite_VO getOneEmp(Integer my_favorite_number) {
		return dao.findByPrimaryKey(my_favorite_number);
	}

	public List<Myfavorite_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Myfavorite_VO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}
