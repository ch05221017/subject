package web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoImpl;
import web.member.service.MailService;
import web.member.service.impl.MailServiceImpl;
import web.seller.dao.SellerDao;
import web.seller.dao.impl.SellerDaoImpl;
import web.vo.Member;
import web.vo.Seller;

/**
 * Servlet implementation class ForgetServlet
 */
@WebServlet("/forget")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String email = req.getParameter("email");
//		if (email != null && email.trim().length() != 0) {
//			
//			
//			session = req.getSession();
//			
//			MemberDao dao;
//			SellerDao dao2;
//			try {
//				dao = new MemberDaoImpl();
//				Member member = new Member();
//				member.setEmail(email);
//				member = dao.selectEmail(member);
//				
//				dao2 = new SellerDaoImpl();
//				Seller seller = new Seller();
//				seller.setEmail(email);
//				seller = dao2.selectEmail(seller);
//				
//				
//				MailService service = new MailServiceImpl();
//				String authCode = service.getAuthCode();
//				service.sendMail(email, " LETITGO樂易購 電子信箱驗證信函", "驗證碼: " + authCode);
//				session.setAttribute("authCode", authCode);
//				System.out.println("已寄出驗證信!!");
//				
//				if (member != null) {
//					session.setAttribute("account", member.getAccount());
//					System.out.println(member.getAccount());
//				} else {
//					session.setAttribute("account", seller.getAccount());
//					System.out.println(seller.getAccount());
//				}
//				req.getRequestDispatcher("/checkVerification.jsp").forward(req, resp);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else {
//			System.out.println("請勿空白!");
//			return;
//		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		if (email != null && email.trim().length() != 0) {
			
			
			session = req.getSession();
			
			MemberDao dao;
			SellerDao dao2;
			try {
				dao = new MemberDaoImpl();
				Member member = new Member();
				member.setEmail(email);
				member = dao.selectEmail(member);
				
				dao2 = new SellerDaoImpl();
				Seller seller = new Seller();
				seller.setEmail(email);
				seller = dao2.selectEmail(seller);
				
				
				MailService service = new MailServiceImpl();
				String authCode = service.getAuthCode();
				service.sendMail(email, " LETITGO樂易購 電子信箱驗證信函", "驗證碼: " + authCode);
				session.setAttribute("authCode", authCode);
				System.out.println("已寄出驗證信!!");
				
				if (member != null) {
					session.setAttribute("account", member.getAccount());
					System.out.println(member.getAccount());
				} else {
					session.setAttribute("account", seller.getAccount());
					System.out.println(seller.getAccount());
				}
				req.getRequestDispatcher("/checkVerification.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("請勿空白!");
			return;
		}
	}

}
