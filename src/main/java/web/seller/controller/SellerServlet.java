package web.seller.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

import web.seller.service.SellerService;
import web.seller.service.impl.SellerServiceImpl;
import web.vo.Seller;

@WebServlet("/seller/*")
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	private String pathInfo;
	private String[] infos;
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setHeaders(req, resp);
		pathInfo = req.getPathInfo();
		infos = pathInfo.split("/");
		session = req.getSession();

		JsonObject respObject = new JsonObject();
		Seller seller = gson.fromJson(req.getReader(), Seller.class);

		if ("register".equals(infos[1])) {
			try {
				SellerService service = new SellerServiceImpl();
				Integer status = service.register(seller);
				if (status > 0) {
					respObject.addProperty("msg", "success");
					session.setAttribute("sellID", seller.getSerialnumber());
					System.out.println(session.getAttribute("sellID"));
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
				SellerService service = new SellerServiceImpl();
				seller = service.login(seller);
				if (seller != null && seller.getAccount().trim().length() != 0
						&& seller.getPassword().trim().length() != 0) {
					respObject.addProperty("msg", "success");
					session.setAttribute("sellID", seller.getSerialnumber());
					System.out.println(session.getAttribute("sellID"));
					// Referenced from
					// https://stackoverflow.com/questions/22585970/how-to-add-an-object-as-a-property-of-a-jsonobject-object
					respObject.add("seller", new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJsonTree(seller));
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
		System.out.println("account: " + account);

		try {
			SellerService service = new SellerServiceImpl();
			Boolean checkAccount = service.checkAccount(account);
			if (checkAccount) {
				respObject.addProperty("msg", "success");
			} else {
				respObject.addProperty("msg", "fail");
			}
			System.out.println("servletSeller1:" + account);
		} catch (NamingException e) {
			e.printStackTrace();
		}

		System.out.println(gson.toJson(respObject));
		resp.getWriter().append(gson.toJson(respObject));
	}

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
