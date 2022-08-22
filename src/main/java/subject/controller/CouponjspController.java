package subject.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.service.CouponjspService;
import subject.vo.CouponjspVO;

@WebServlet("/administrator/couponjsp.do")
public class CouponjspController extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
//		System.out.println("abc");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("couponserialnumber");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/administrator/couponall.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer couponserialnumber = null;
			try {
				couponserialnumber = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/administrator/couponall.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			CouponjspService couponjspSvc = new CouponjspService();
			CouponjspVO couponjspVO = couponjspSvc.getOneCouponjsp(couponserialnumber);
			if (couponjspVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/administrator/couponall.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("couponjspVO", couponjspVO); // 資料庫取出的Coupon物件,存入req
			String url = "/administrator/couponall.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求
			
//			System.out.println(action);
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer couponserialnumber = Integer.valueOf(req.getParameter("couponserialnumber"));

			/*************************** 2.開始查詢資料 ****************************************/
			CouponjspService couponjspSvc = new CouponjspService();
			CouponjspVO couponjspVO = couponjspSvc.getOneCouponjsp(couponserialnumber);
//			System.out.println(couponjspVO);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("couponjspVO", couponjspVO); // 資料庫取出的Coupon物件,存入req
//			System.out.println("xxxxxxxxx="+couponjspVO.getStartdate());
			String url = "/administrator/coupon/couponupdate.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer couponserialnumber = Integer.valueOf(req.getParameter("couponserialnumber").trim());

			String couponname = req.getParameter("couponname").trim();
			if (couponname == null || couponname.trim().length() == 0) {
				errorMsgs.add("名稱請勿空白!");
			}

			java.sql.Date startdate = null;
			try {
				
				startdate = java.sql.Date.valueOf(req.getParameter("startdate").trim());
			} catch (IllegalArgumentException e) {
				startdate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入開始日期!");
			}
			java.sql.Date enddate = null;
			try {
				enddate = java.sql.Date.valueOf(req.getParameter("enddate").trim());
			} catch (IllegalArgumentException e) {
				enddate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入結束日期!");
			}

			Float refundpercent = null;
			try {
				 refundpercent = Float.valueOf(req.getParameter("refundpercent").trim());						
			} catch (RuntimeException e) {
				errorMsgs.add("回饋數請勿空白!");
			}


			CouponjspVO couponjspVO = new CouponjspVO();
			couponjspVO.setCouponserialnumber(couponserialnumber);		
			couponjspVO.setCouponname(couponname);
			couponjspVO.setStartdate(startdate);
			couponjspVO.setEnddate(enddate);
			couponjspVO.setRefundpercent(refundpercent);

// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponjspVO", couponjspVO); // 含有輸入格式錯誤的Coupon物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("./coupon/couponupdate.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			CouponjspService couponjspSvc = new CouponjspService();
			couponjspVO = couponjspSvc.updateCouponjsp(couponserialnumber, couponname, startdate, enddate, refundpercent);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("couponjspVO", couponjspVO); // 資料庫update成功後,正確的的Coupon物件,存入req
			String url = "/administrator/couponall.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
//String aaa = req.getParameter("couponname");
//System.out.println(aaa);
			List<String> errorMsgs = new LinkedList<String>();
// Store this set in the request scope, in case we need to
// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			String couponname = req.getParameter("couponname").trim();
			if (couponname == null || couponname.trim().length() == 0) {
				errorMsgs.add("名稱請勿空白!");
			}

			java.sql.Date startdate = null;
			try {
				startdate = java.sql.Date.valueOf(req.getParameter("startdate").trim());
			} catch (IllegalArgumentException e) {
				startdate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入開始日期!");
			}
			java.sql.Date enddate = null;
			try {
				enddate = java.sql.Date.valueOf(req.getParameter("enddate").trim());
			} catch (IllegalArgumentException e) {
				enddate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入結束日期!");
			}
			
			Float refundpercent = null;
			try {
				String refundpercentStr = req.getParameter("refundpercent");
				refundpercentStr = refundpercentStr.trim();
				refundpercent = Float.valueOf(refundpercentStr);				
			} catch (RuntimeException e) {
				errorMsgs.add("回饋數請勿空白!");
			}

			CouponjspVO couponjspVO = new CouponjspVO();			
			couponjspVO.setCouponname(couponname);
			couponjspVO.setStartdate(startdate);
			couponjspVO.setEnddate(enddate);
			couponjspVO.setRefundpercent(refundpercent);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("couponjspVO", couponjspVO); // 含有輸入格式錯誤的Coupon物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("./coupon/couponadd.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 **********************O*****************/
			CouponjspService couponjspSvc = new CouponjspService();
			couponjspVO = couponjspSvc.addCouponjsp(couponname, startdate, enddate, refundpercent);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/administrator/couponall.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp
//			System.out.println(action);
			List<String> errorMsgs = new LinkedList<String>();
// Store this set in the request scope, in case we need to
// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer couponserialnumber = Integer.valueOf(req.getParameter("couponserialnumber"));

			/*************************** 2.開始刪除資料 ***************************************/
			CouponjspService couponserialnumberSvc = new CouponjspService();
			couponserialnumberSvc.deleteCouponjsp(couponserialnumber);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/administrator/couponall.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
