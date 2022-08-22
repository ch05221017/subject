package subject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.FlashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import subject.service.CouponVerifyService;
import subject.service.impl.CouponVerifyServiceImpl;
import subject.vo.Coupon;

@WebServlet("/CouponVerify")
//購物車coupon驗證
public class CouponVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json;charset=UTF-8");
		Gson gson = new Gson();
		JsonObject resObj = new JsonObject();
		try {
			Coupon coupon = gson.fromJson(req.getReader(), Coupon.class);
			CouponVerifyService couponVerifyService = new CouponVerifyServiceImpl();
			final String Msg = couponVerifyService.Couponverify(coupon.getCouponname()); // 傳入之參數交給couponVerifyService處理
			resObj.addProperty("Msg", Msg);
			// 如果使用Coupon券成功，將coupon流水號回傳前端
			if (Msg.equals("使用Coupon券成功，本次回饋數為"
					+ String.valueOf(couponVerifyService.Couponrefundpercent(coupon.getCouponname())))) {
				String couponnamestr = couponVerifyService.Couponnamestr(coupon.getCouponname());
				String couponnamejstr = gson.toJson(couponnamestr);
				resObj.addProperty("couponnamejstr", couponnamejstr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resObj.addProperty("Msg", "系統錯誤");
		}
		res.getWriter().append(gson.toJson(resObj));
	}

}
