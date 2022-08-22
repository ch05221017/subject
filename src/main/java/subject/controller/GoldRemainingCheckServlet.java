package subject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import subject.service.GoldRemainingCheckService;
import subject.service.impl.GoldRemainingCheckServiceImpl;
import subject.vo.MemberHibernate;

@WebServlet("/GoldRemainingCheck")
public class GoldRemainingCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		JsonObject resObj = new JsonObject();
		try {
			MemberHibernate memberHibernate = gson.fromJson(req.getReader(), MemberHibernate.class);
			System.out.println(memberHibernate);
			GoldRemainingCheckService goldRemainingCheckService = new GoldRemainingCheckServiceImpl();
			final String Msg = goldRemainingCheckService.CouponverifyGoldRemaining(memberHibernate.getGoldremaining()); // 傳入之參數交給couponVerifyService處理
			resObj.addProperty("Msg", Msg);
		} catch (Exception e) {
			e.printStackTrace();
			resObj.addProperty("Msg", "系統錯誤");
		}
		res.getWriter().append(gson.toJson(resObj));
	}
}
