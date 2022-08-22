package subject.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.hibernate.HibernateUtil;
import subject.dao.OrderDetailDao;
import subject.vo.OrderDetailHibernate;

public class OrderDetailDaoImpl implements OrderDetailDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); // 從controller移到這

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable insert(OrderDetailHibernate vo) {
		return getSession().save(vo);
	}
}
