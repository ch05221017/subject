package subject.service.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import subject.dao.CouponDao;
import subject.dao.OrderDetailDao;
import subject.dao.OrderMainFileHibernateDao;
import subject.dao.impl.CouponDaoImpl;
import subject.dao.impl.OrderDetailDaoImpl;
import subject.dao.impl.OrderMainFileHibernateDaoImpl;
import subject.service.OrderMainFileHibernateService;
import subject.vo.OrderDetailHibernate;
import subject.vo.OrderMainFileHibernate;
import suject.cart.Cart;
import suject.cart.Cartlist;

public class OrderMainFileHibernateServiceImpl implements OrderMainFileHibernateService {
	private CouponDao couponDao;
	private OrderMainFileHibernateDao orderMainFileHibernateDao;
	Calendar calendar = Calendar.getInstance();
	private OrderDetailDao orderDetailDao;

	public OrderMainFileHibernateServiceImpl() {
		couponDao = new CouponDaoImpl();
		orderMainFileHibernateDao = new OrderMainFileHibernateDaoImpl();
		orderDetailDao = new OrderDetailDaoImpl();
	}

	public String orderMaininsert(String couponname, Cart cart, List<Cartlist> cartlist, Integer carttotal) {
		Integer orderserialnumber = null;
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//		Date curtime= strToDateLong(dateFormat.format(calendar.getTime()));
		if (couponname == null || Objects.equals(couponname, "")) {
			OrderMainFileHibernate orderMainFileHibernate = new OrderMainFileHibernate();
			orderMainFileHibernate.setMemberserialnumber(1636010);
			orderMainFileHibernate.setSellerserialnumber(1000);
			orderMainFileHibernate.setOrderstatusnumber("1");
			orderMainFileHibernate.setSellerevaluationstar(2);
			orderMainFileHibernate.setMemberevaluationstar(4);
			orderMainFileHibernate.setSellerevaluationdescription("");
			orderMainFileHibernate.setMemberevaluationdescription("");
//			orderMainFileHibernate.setMemberevaluationphoto();
			orderMainFileHibernate.setOrderamount(cart.carttotal);
			orderMainFileHibernate.setOrderdate(calendar.getTime());
			Serializable pk1 = orderMainFileHibernateDao.insert(orderMainFileHibernate);
			System.out.println("id1=" + ((OrderMainFileHibernate) pk1).getOrderserialnumber());
			orderserialnumber = ((OrderMainFileHibernate) pk1).getOrderserialnumber();
			if (orderserialnumber != null) {
				for (Cartlist cartlist1 : cart.cartlist) {
					OrderDetailHibernate oderitem2 = new OrderDetailHibernate(); // orderdetail1
					oderitem2.setOrderserialnumber(orderserialnumber);
					oderitem2.setItemserialnumber(cartlist1.itemserialnumber);
					oderitem2.setOrderdetailprice(cartlist1.itemprice);
					oderitem2.setOrderdetailquantity(cartlist1.itemquantity);
					oderitem2.setRefundreason("");
					oderitem2.setOrderdetailstatus(2);
					orderDetailDao.insert(oderitem2);
				}
				return "訂單主檔+細項新增成功";
			}
			return "新增成功";

		} else {
			OrderMainFileHibernate orderMainFileHibernate = new OrderMainFileHibernate();
			orderMainFileHibernate.setMemberserialnumber(1636010);
			orderMainFileHibernate.setSellerserialnumber(1000);
			orderMainFileHibernate.setOrderstatusnumber("1");
			orderMainFileHibernate.setCouponserialnumber(couponDao.selectcouponserialnumber(couponname));
			// orderMainFileHibernate.setCouponserialnumber(5);
			orderMainFileHibernate.setSellerevaluationstar(2);
			orderMainFileHibernate.setMemberevaluationstar(4);
			orderMainFileHibernate.setSellerevaluationdescription("");
			orderMainFileHibernate.setMemberevaluationdescription("");
			// orderMainFileHibernate.setMemberevaluationphoto();
			orderMainFileHibernate.setOrderamount(cart.carttotal);
			orderMainFileHibernate.setOrderdate(calendar.getTime());
			Serializable pk2 = orderMainFileHibernateDao.insert(orderMainFileHibernate);
			System.out.println("id2=" + ((OrderMainFileHibernate) pk2).getOrderserialnumber());
			orderserialnumber = ((OrderMainFileHibernate) pk2).getOrderserialnumber();
			/// ====================
			if (orderserialnumber != null) {
				for (Cartlist cartlist1 : cart.cartlist) {
					OrderDetailHibernate oderitem = new OrderDetailHibernate(); // orderdetail1
					oderitem.setOrderserialnumber(orderserialnumber);
					oderitem.setItemserialnumber(cartlist1.itemserialnumber);
					oderitem.setOrderdetailprice(cartlist1.itemprice);
					oderitem.setOrderdetailquantity(cartlist1.itemquantity);
					oderitem.setRefundreason("");
					oderitem.setOrderdetailstatus(2);
					orderDetailDao.insert(oderitem);
				}

				return "訂單主檔+細項新增成功";
			}
			return "訂單主檔新增成功";
		}

	}

//	 public static Date strToDateLong(String strDate) {
//		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		    ParsePosition pos = new ParsePosition(0);
//		    Date strtodate = formatter.parse(strDate, pos);
//		    return strtodate;
//		 }

}
