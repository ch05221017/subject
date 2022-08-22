package subject.dao.impl;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import model.hibernate.HibernateUtil;
import subject.dao.CouponDao;
import subject.dao.CouponRecordDao;
import subject.vo.Coupon;
import subject.vo.CouponRecord;

public class CouponRecordDaoImpl implements CouponRecordDao {
	private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();  //從controller移到這;

	public CouponRecordDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public CouponRecordDaoImpl() {
	}
	
//select方法(比對紀錄、查詢該會員使用優惠券狀態)
	String couponrecordhql = "select couponrecordstatus from CouponRecord where couponserialnumber = :couponserialnumber and memberserialnumber = :memberserialnumber";
	CouponDao couponDao;
	Coupon coupon;
	@Override
	public Integer selectbyrecordpk(String couponname, Integer memberserialnumber) {
		couponDao = new CouponDaoImpl(sessionFactory);
	
		Integer resultscouponrecord = getSession().createQuery(couponrecordhql, Integer.class)
				.setParameter("couponserialnumber", couponDao.selectcouponserialnumber(couponname))
				.setParameter("memberserialnumber", memberserialnumber).uniqueResult();	
		return resultscouponrecord;
	}


////insert方法(消費者使用時新增紀錄)
	@Override
	public CouponRecord insert(CouponRecord couponRecord) {
		if (couponRecord != null && couponRecord.getCouponserialnumber() != null) {
				Serializable pk = this.getSession().save(couponRecord);
				return couponRecord;
		}
		return null;
	}
}
