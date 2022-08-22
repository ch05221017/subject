package web.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class checkVerification
 */
@WebServlet("/checkVerification")
public class CheckVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;  

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String inputAuthCode = req.getParameter("authCode");
//		session = req.getSession();
//		session.removeAttribute("msg");
//		if (inputAuthCode != null && inputAuthCode.trim().length() != 0) {		
//			String authCode = (String) session.getAttribute("authCode");
//			if (authCode.equals(inputAuthCode)) {
//				System.out.println("驗證成功");
//				req.getRequestDispatcher("/changePassword.jsp").forward(req, resp);
//			} else {
//				System.out.println("驗證失敗");
//				req.getRequestDispatcher("/checkVerification.jsp").forward(req, resp);
//				session.setAttribute("msg", "輸入錯誤，請填寫正確驗證碼!!");
//			}
//		}else {
//			System.out.println("請勿空白!");
//			return;
//		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String inputAuthCode = req.getParameter("authCode");
		session = req.getSession();
		if (inputAuthCode != null && inputAuthCode.trim().length() != 0) {		
			session.removeAttribute("msg");
			String authCode = (String) session.getAttribute("authCode");
			if (authCode.equals(inputAuthCode)) {
				System.out.println("驗證成功");
				req.getRequestDispatcher("/changePassword.jsp").forward(req, resp);
			} else {
				System.out.println("驗證失敗");
				session.setAttribute("msg", "輸入錯誤，請填寫正確驗證碼!!");
				req.getRequestDispatcher("/checkVerification.jsp").forward(req, resp);
			}
		}else {
			System.out.println("請勿空白!");
			return;
		}
	}

}
