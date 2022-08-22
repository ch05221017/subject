package subject.service;

import java.util.List;


import subject.dao.CouponjspDAO;
import subject.dao.CouponjspDAO_interface;
import subject.vo.CouponjspVO;


public class CouponjspService {
	private CouponjspDAO_interface dao;

	public CouponjspService() {
		dao = new CouponjspDAO();
	}

	public CouponjspVO addCouponjsp(String couponname, java.sql.Date startdate,
			java.sql.Date enddate, Float refundpercent) {

		CouponjspVO couponjspVO = new CouponjspVO();
		
		couponjspVO.setCouponname(couponname);
		couponjspVO.setStartdate(startdate);
		couponjspVO.setEnddate(enddate);
		couponjspVO.setRefundpercent(refundpercent);	
		dao.insert(couponjspVO);

		return couponjspVO;
	}

	public CouponjspVO updateCouponjsp(Integer couponserialnumber, String couponname,
			java.sql.Date startdate, java.sql.Date enddate, Float refundpercent) {

		CouponjspVO couponjspVO = new CouponjspVO();

		couponjspVO.setCouponserialnumber(couponserialnumber);
		couponjspVO.setCouponname(couponname);
		couponjspVO.setStartdate(startdate);
		couponjspVO.setEnddate(enddate);
		couponjspVO.setRefundpercent(refundpercent);		
		dao.update(couponjspVO);

		return couponjspVO;
	}

	public void deleteCouponjsp(Integer couponserialnumber) {
		dao.delete(couponserialnumber);
	}
	
	public CouponjspVO getOneCouponjsp(Integer couponserialnumber) {
		return dao.findByPrimaryKey(couponserialnumber);
	}

	public List<CouponjspVO> getAll() {
		return dao.getAll();
	}
}
