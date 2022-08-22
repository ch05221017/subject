package web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.vo.Member;

/**
 * Servlet implementation class checkVerification
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
//	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		System.out.println("LogOut");
		if (session == null) {
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			return;
		}
		session.removeAttribute("memID");
		session.removeAttribute("sellID");
//		System.out.println(session.getAttribute("memID"));
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		Member member = gson.fromJson(req.getReader(), Member.class);
//		System.out.println(member.getName());

//		String jsonStr = "";
//		JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
//		String name = jsonObject.get("name").getAsString();
//		
//		session = req.getSession();
//		if ("admin".equals(name)) {
//			session.removeAttribute("memID");
//			System.out.println("登出成功!!");
//		} else {
//			System.out.println("登出失敗!!");
//		}

	}

}
