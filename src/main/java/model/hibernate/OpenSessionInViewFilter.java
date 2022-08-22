package model.hibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
@WebFilter(
		urlPatterns = {"/*"}
		)
public class OpenSessionInViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		System.out.println("OpenSessionInViewFilter-Start");
		try {
			transaction = session.beginTransaction();
			chain.doFilter(request, response); // 呼叫後端Servlet
//			if (transaction.isActive()) {
				transaction.commit();
//			}
			System.out.println("OpenSessionInViewFilter-try");
		} catch (Exception e) {
			System.out.println("OpenSessionInViewFilter-catch");
			transaction.rollback();
//			chain.doFilter(request, response);
			e.printStackTrace();
		
		}finally {
			session.close();
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
