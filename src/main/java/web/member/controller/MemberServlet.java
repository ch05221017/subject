package web.member.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;
import web.vo.Member;

@WebServlet("/member/*")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PASSWORD_REGEX = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String ACCOUNT_REGEX = "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*$";

	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test");
		setHeaders(req, resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		session = req.getSession();

		JsonObject respObject = new JsonObject();
		Member member = gson.fromJson(req.getReader(), Member.class);
		if ("register".equals(infos[1])) {
			try {
				MemberService service = new MemberServiceImpl();
//				System.out.println("明碼: "+member.getPassword());
				Integer status = service.register(member);
				if (status > 0) {
					respObject.addProperty("msg", "success");
					session.setAttribute("memID", member.getMemberserialnumber());
					System.out.println(session.getAttribute("memID"));
				} else {
					respObject.addProperty("msg", "fail");
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			System.out.println(gson.toJson(respObject));
			resp.getWriter().append(gson.toJson(respObject));
		} else if ("login".equals(infos[1])) {
			try {
				MemberService service = new MemberServiceImpl();
				member = service.login(member);
				boolean matcher = Pattern.matches(PASSWORD_REGEX, member.getPassword());

				if (member != null && member.getAccount().trim().length() != 0
						&& member.getPassword().trim().length() != 0) {
					respObject.addProperty("msg", "success");
					session.setAttribute("memID", member.getMemberserialnumber());
					System.out.println(session.getAttribute("memID"));
					// Referenced from
					// https://stackoverflow.com/questions/22585970/how-to-add-an-object-as-a-property-of-a-jsonobject-object
					respObject.add("member", gson.toJsonTree(member));
				} else {
					respObject.addProperty("msg", "fail");
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			System.out.println(gson.toJson(respObject));
			resp.getWriter().append(gson.toJson(respObject));
		}


	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		
		JsonObject respObject = new JsonObject();
		String account = req.getParameter("account");
		System.out.println("account: "+account);

		try {
			MemberService service = new MemberServiceImpl();
			Boolean checkAccount = service.checkAccount(account);
			if (checkAccount) {
				respObject.addProperty("msg", "success");
			} else {
				respObject.addProperty("msg", "fail");
			}
			System.out.println("servletMember1:" + account);
		} catch (NamingException e) {
			e.printStackTrace();
		}
				

		System.out.println(gson.toJson(respObject));
		resp.getWriter().append(gson.toJson(respObject));
	}

//		try {
////			Gson gson = new Gson();
//			Member member = gson.fromJson(req.getReader(), Member.class);
////			System.out.println(member.getAccount());
////			System.out.println(member.getPassword());
//			MemberDao dao;
//			dao = new MemberDaoImpl();
////			System.out.println(dao.selectForLogin(account, password));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 

//		String account = req.getParameter("account");
//		String password = req.getParameter("password");
//		MemberDao dao;
//		try {
//			dao = new MemberDaoImpl();
//			Member member = new Member();
//			member.setAccount(account);
//			member.setPassword(password);
//			member = dao.selectForLogin(account, password);
//			System.out.println("登入成功!!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	/*
	 * 誇域
	 */
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setHeaders(req, resp);
	}

	private void setHeaders(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		// 重要
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		// 重要
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Max-Age", "86400");
	}
}
