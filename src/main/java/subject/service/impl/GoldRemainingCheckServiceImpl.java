package subject.service.impl;

import subject.dao.MemberHibernateDao;
import subject.dao.impl.MemberHibernateDaoImpl;
import subject.service.GoldRemainingCheckService;
import subject.vo.MemberHibernate;

public class GoldRemainingCheckServiceImpl implements GoldRemainingCheckService {
	private MemberHibernateDao memberHibernateDao;
	MemberHibernate memberHibernate;

	public GoldRemainingCheckServiceImpl() {
		memberHibernateDao = new MemberHibernateDaoImpl();
	}

	@Override
	public String CouponverifyGoldRemaining(Integer goldremaining) {
		if (goldremaining != null) {
			if (goldremaining <= memberHibernateDao.selectgoldremaininghibernate(goldremaining)) {
				return "購物金使用成功";
			} else {
				return "購物金餘額不足";
			}
		} else {
			return "請輸入欲使用購物金金額";
		}
	}
}
