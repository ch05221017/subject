package subject.service.impl;

import java.util.Date;
import java.util.Objects;

import javax.naming.NamingException;

import subject.dao.CouponDao;
import subject.dao.impl.CouponDaoImpl;
import subject.service.CouponService;
import subject.vo.Coupon;

public class CouponServiceImpl implements CouponService {
	private CouponDao dao;

	public CouponServiceImpl() throws NamingException {
		dao = new CouponDaoImpl();
	}

	@Override
	public String newcoupon(Coupon coupon) {

		final String couponname = coupon.getCouponname();
		if (couponname == null || Objects.equals(couponname, "")) {
			return "名稱必須輸入";
		}

		final Date startdate = coupon.getStartdate();
		if (startdate == null || Objects.equals(String.valueOf(startdate), "")) {
			return "開始日期必須輸入";
		}

		final Date enddate = coupon.getEnddate();
		if (enddate == null || Objects.equals(String.valueOf(enddate), "")) {
			return "結束日期必須輸入";
		}

		final Float refundpercent = coupon.getRefundpercent();
		if (refundpercent == null) {
			return "回饋數必須輸入";
		}
		final Coupon result = dao.insert(coupon);
		if (result == null) {
			return "系統錯誤，請聯絡管理員";
		}
		return null;
	}

}
