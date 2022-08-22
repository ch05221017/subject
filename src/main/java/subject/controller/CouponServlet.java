package subject.controller;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import model.hibernate.HibernateUtil;
import subject.dao.CouponDao;
import subject.dao.impl.CouponDaoImpl;
import subject.service.CouponService;
import subject.service.impl.CouponServiceImpl;
import subject.vo.Coupon;

@WebServlet("/Coupon")
public class CouponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// RESTful
	@Override // new_Coupon_insert()
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json;charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JsonObject resObj = new JsonObject();

		try {
			Coupon coupon = gson.fromJson(req.getReader(), Coupon.class);
			CouponService service = new CouponServiceImpl();
			final String errMsg = service.newcoupon(coupon);
			resObj.addProperty("errMsg", errMsg);		
		} catch (Exception e) {
			e.printStackTrace();
			resObj.addProperty("errMsg", "系統錯誤");
		}
		res.getWriter().append(gson.toJson(resObj));
	}

	@Override // Coupon_selectAll
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application//json;charset=UTF-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		CouponDao dao;
		try {
			dao = new CouponDaoImpl();
			List<Coupon>coupon=dao.selectall();
			String resS = gson.toJson(coupon);
			res.getWriter().append(resS);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}