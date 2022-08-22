package web.member.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoImpl;
import web.member.service.MailService;
import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;
import web.seller.dao.SellerDao;
import web.seller.dao.impl.SellerDaoImpl;
import web.seller.service.SellerService;
import web.seller.service.impl.SellerServiceImpl;
import web.vo.Member;
import web.vo.Seller;

/**
 * Servlet implementation class checkVerification
 */
@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String newPassword = req.getParameter("newPassword");
		String checkPassword = req.getParameter("checkPassword");
		session = req.getSession();
		String account = (String) session.getAttribute("account");
		Boolean np = newPassword != null && newPassword.trim().length() != 0;
		Boolean cp = checkPassword != null && checkPassword.trim().length() != 0;

		Member member = new Member();
		MemberDao dao;
		Seller seller = new Seller();
		SellerDao dao2;
		try {
			dao = new MemberDaoImpl();
			dao2 = new SellerDaoImpl();
			MemberService service = new MemberServiceImpl();
			SellerService service2 = new SellerServiceImpl();
			if (np && cp && newPassword.equals(checkPassword)) {
				System.out.println("兩次密碼輸入相同!!");
				Integer status = null;
				if (member != null) {
					member.setPassword(newPassword);
					member.setAccount(account);
					status = service.changePassword(member);
				}
				seller.setPassword(newPassword);
				seller.setAccount(account);
				status = service2.changePassword(seller);

				System.out.println("UpdatePassword:" + status);
				req.getRequestDispatcher("/login.html").forward(req, resp);
			} else {
				System.out.println("兩次密碼輸入不相同，請再次確認!!");
				return;
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
