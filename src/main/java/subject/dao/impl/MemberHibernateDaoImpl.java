package subject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.hibernate.HibernateUtil;
import subject.dao.MemberHibernateDao;



public class MemberHibernateDaoImpl implements MemberHibernateDao {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  //從controller移到這

	public MemberHibernateDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public MemberHibernateDaoImpl() {
	}
	
	//select購物金存量方法(利用會員ID)
	String Memberhq1 = "select goldremaining from MemberHibernate where memberserialnumber = :memberserialnumber "; // HQL
	@Override
	public Integer selectgoldremaininghibernate(Integer memberserialnumber) {
		Integer resultone = getSession().createQuery(Memberhq1, Integer.class) // HQL
				.setParameter("memberserialnumber", 1636001)
				.uniqueResult();
		return resultone;
	}
	
	

}
