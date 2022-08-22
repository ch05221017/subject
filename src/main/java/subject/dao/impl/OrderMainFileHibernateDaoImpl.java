package subject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.hibernate.HibernateUtil;
import subject.dao.OrderMainFileHibernateDao;
import subject.vo.OrderMainFileHibernate;

public class OrderMainFileHibernateDaoImpl implements OrderMainFileHibernateDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); // 從controller移到這

	public OrderMainFileHibernateDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public OrderMainFileHibernateDaoImpl() {
	}

	// insert
	@Override
	public OrderMainFileHibernate insert(OrderMainFileHibernate orderMainFileHibernate) {
//		System.out.println("merge-method");
//		return (OrderMainFileHibernate) getSession().merge(orderMainFileHibernate);
		System.out.println("merge-method");
		Session session = getSession();
		OrderMainFileHibernate vo = (OrderMainFileHibernate) session.merge(orderMainFileHibernate);
//		session.getTransaction().commit();
		return vo;
	}

}
