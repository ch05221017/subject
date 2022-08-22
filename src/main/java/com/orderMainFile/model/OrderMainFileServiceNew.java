package com.orderMainFile.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.orderDetail.model.OrderDetailVO;

// import subject.dao.CouponDao;
// import subject.dao.impl.CouponDaoImpl;
// import suject.cart.Cart;
// import suject.cart.Cartlist;

public class OrderMainFileServiceNew {
//	OrderMainFileDAO dao;
//	OrderMainFileVO orderMainFileVO;
//	private CouponDao couponDao;
//	private Cart cart;
//
//	public OrderMainFileServiceNew() {
////		public static void main(String[] args) {
//
//		dao = new OrderMainFileDAO();
//
//		orderMainFileVO = new OrderMainFileVO();
//		couponDao = new CouponDaoImpl();
//	}
//
//	public String insertWithOrderDetail(String couponname, Integer itemserialnumber, Integer itemprice,
//			Integer itemquantity) {
////		,String itemname
//		if (couponname == null || Objects.equals(couponname, "")) {
//			orderMainFileVO.setMemberserialnumber(1636001);
//			orderMainFileVO.setSellerserialnumber(1000);
//			orderMainFileVO.setOrderstatusnumber("1");
////		orderMainFileVO.setCouponserialnumber(1);
//			orderMainFileVO.setSellerevaluationstar(3);
//			orderMainFileVO.setMemberevaluationstar(3);
//			orderMainFileVO.setSellerevaluationdescription("");
//			orderMainFileVO.setMemberevaluationdescription("");
//			orderMainFileVO.setOrderamount(5555555);
//			orderMainFileVO.setOrderdate(java.sql.Date.valueOf("2022-08-06"));
////		return "新增成功!";
//		} else {
//			orderMainFileVO.setMemberserialnumber(1636001);
//			orderMainFileVO.setSellerserialnumber(1000);
//			orderMainFileVO.setOrderstatusnumber("1");
//			orderMainFileVO.setCouponserialnumber(couponDao.selectcouponserialnumber(couponname));
//			orderMainFileVO.setSellerevaluationstar(3);
//			orderMainFileVO.setMemberevaluationstar(3);
//			orderMainFileVO.setSellerevaluationdescription("");
//			orderMainFileVO.setMemberevaluationdescription("");
//			orderMainFileVO.setOrderamount(5555555);
//			orderMainFileVO.setOrderdate(java.sql.Date.valueOf("2022-08-06"));
////		return "新增成功!";	
//		}
//
//		List<OrderDetailVO> testList = new ArrayList<OrderDetailVO>(); // 準備置入orderdetail筆數
//		OrderDetailVO odXX = new OrderDetailVO(); // orderdetail1
//
////		Integer itemserialnumber=null;
////		for (int i = 0; i < cart.cartlist.size(); i++) { 
//		for (Cartlist cartlist : cart.cartlist) { // 測試商品接收(疊代用法)
//			System.out.println("cartobj=" + cartlist);
////			itemserialnumber=cartlist.itemserialnumber;		
//
//			odXX.setItemserialnumber(itemserialnumber);
//			odXX.setOrderdetailprice(itemprice);
//			odXX.setOrderdetailquantity(itemquantity);
//			odXX.setRefundreason("");
//			odXX.setOrderdetailstatus(1);
////		}
////		OrderDetailVO odyy = new OrderDetailVO();   // orderdetail2
////		odyy.setItemserialnumber(itemserialnumber);
////		odyy.setOrderdetailprice(itemprice);
////		odyy.setOrderdetailquantity(itemquantity);
////		odyy.setRefundreason("");
////		odyy.setOrderdetailstatus(1);
//
//		testList.add(odXX);
////		testList.add(odyy);
//		}
//		dao.insertWithOrderDetail(orderMainFileVO, testList);
//		
//		return "訂單主檔+細項新增成功";
//		
//	}

}