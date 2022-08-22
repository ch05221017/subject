package com.mycart.controller;

import java.io.IOException;
import java.net.Authenticator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.item_category.model.Item_category_Service;
import com.item_category.model.Item_category_VO;
import com.mycart.model.Mycart_Service;
import com.mycart.model.Mycart_VO;
import com.myfavorite.model.Myfavorite_Service;
import com.myfavorite.model.Myfavorite_VO;
@WebServlet("/Mycart_Servlet")
public class Mycart_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("123");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		if("getOne_For_Display_For_item_category".equals(action)) {
//			System.out.println("getOne_For_Display_For_item_category in");
//		}
		
		
		if ("add_cart".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("abc");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String add_cart_number = req.getParameter("add_cart_number");
				String item_number_cart = req.getParameter("item_number_cart");
				String member_number_cart = req.getParameter("member_number_cart");
//				if (str == null || (str.trim()).length() == 0) {
//					errorMsgs.add("請輸入員工編號");
//				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer add_cart_number1 = Integer.parseInt(add_cart_number);
				Integer item_number_cart1 = Integer.parseInt(item_number_cart);
				Integer member_number_cart1 = Integer.parseInt(member_number_cart);

				
				
				Mycart_VO Mycart_VO = new Mycart_VO();
				Mycart_VO.setMember_serial_number(member_number_cart1);
				Mycart_VO.setItem_serial_number(item_number_cart1);
				Mycart_VO.setNon_member_serial_number(1);
				Mycart_VO.setCart_item_quantity(add_cart_number1);
				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
				
				/***************************2.開始查詢資料*****************************************/
//				Mycart_Service cartSvc = new Mycart_Service();
//				Mycart_VO Mycart_VO = cartSvc.getOneEmp(cart_serial_number);
				
				Mycart_Service cartSvc = new Mycart_Service();
				Mycart_VO = cartSvc.addEmp( member_number_cart1, item_number_cart1, 1,add_cart_number1 );
				
//				
//				if (Mycart_VO == null) {
//					errorMsgs.add("查無資料");
//				}
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/select_page.jsp");
//					failureView.forward(req, res);
//					return;//程式中斷
//				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("Mycart_VO", Mycart_VO); // 資料庫取出的Item_category_VO物件,存入req
				String url = "/shoping-cart.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("add_myfavorite".equals(action)) { // 來自select_page.jsp的請求
			System.out.println("abc");
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/


			Integer item_number = Integer.valueOf(req.getParameter("item_number"));
			System.out.println("d");
			Integer member_number = Integer.valueOf(req.getParameter("member_number"));
			System.out.println("e");
			System.out.println(item_number);
			System.out.println(member_number);
			
			

			Myfavorite_VO Myfavorite_VO = new Myfavorite_VO();
			Myfavorite_VO.setItem_serial_number(item_number);
			Myfavorite_VO.setMember_serial_number(member_number);



			
			/***************************2.開始新增資料***************************************/
			Myfavorite_Service myfavorite_Service = new Myfavorite_Service();
			Myfavorite_VO = myfavorite_Service.addEmp(item_number, member_number);
			
			
			
//			Integer item_number = Integer.parseInt(item_number);
			
			
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/select_page.jsp");
//				failureView.forward(req, res);
//				return;//程式中斷
//			}
//			
			/***************************2.開始查詢資料*****************************************/
//			Item_category_Service empSvc = new Item_category_Service();
//			Item_category_VO Item_category_VO = empSvc.getOneEmp(item_category_number);
//			if (Item_category_VO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req
//						.getRequestDispatcher("/select_page.jsp");
//				failureView.forward(req, res);
//				return;//程式中斷
//			}
			
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//			req.setAttribute("Item_category_VO", Item_category_VO); // 資料庫取出的Item_category_VO物件,存入req
			String url = "/index.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
			successView.forward(req, res);
		}
//		
//		
//		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp 的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】		
//			
//				/***************************1.接收請求參數****************************************/
//				Integer item_category_number = Integer.valueOf(req.getParameter("item_category_number"));
//				
//				/***************************2.開始查詢資料****************************************/
//				Item_category_Service empSvc = new Item_category_Service();
//				Item_category_VO Item_category_VO = empSvc.getOneEmp(item_category_number);
//								
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("Item_category_VO", Item_category_VO); // 資料庫取出的Item_category_VO物件,存入req
//				String url = "/emp/update_emp_input.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交update_emp_input.jsp
//				successView.forward(req, res);
//		}
		
		
//		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			String requestURL = req.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
//		
//				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//				Integer empno = Integer.valueOf(req.getParameter("empno").trim());
//				
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//				String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}		
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//
//				Double sal = null;
//				try {
//					sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//
//				Double comm = null;
//				try {
//					comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//
//				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//				Item_category_VO Item_category_VO = new Item_category_VO();
//				Item_category_VO.setItem_category_number(item_category_number);
//				Item_category_VO.setItem_category_main_name(item_category_main_name);
//				Item_category_VO.setItem_category_area_name(item_category_area_name);
//				Item_category_VO.setItem_category_detail_name(item_category_detail_name);
//
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("Item_category_VO", Item_category_VO); // 含有輸入格式錯誤的Item_category_VO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //程式中斷
//				}
//				
//				/***************************2.開始修改資料*****************************************/
//				EmpService empSvc = new EmpService();
//				Item_category_VO = empSvc.updateEmp(item_category_number, item_category_main_name, item_category_area_name, item_category_detail_name);
//				
//				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
//				DeptService deptSvc = new DeptService();
//				if(requestURL.equals("/dept/listEmps_ByDeptno.jsp") || requestURL.equals("/dept/listAllDept.jsp"))
//					req.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(deptno)); // 資料庫取出的list物件,存入request
//
//                String url = requestURL;
//				RequestDispatcher successView = req.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
//				successView.forward(req, res);
//		}

//        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
//			
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//				String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}
//				
//				java.sql.Date hiredate = null;
//				try {
//					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//				
//				Double sal = null;
//				try {
//					sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//				
//				Double comm = null;
//				try {
//					comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//				
//				Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
//				Item_category_VO Item_category_VO = new Item_category_VO();
//				Item_category_VO.setItem_category_main_name(item_category_main_name);
//				Item_category_VO.setItem_category_area_name(item_category_area_name);
//				Item_category_VO.setItem_category_detail_name(item_category_detail_name);
//
//
//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("Item_category_VO", Item_category_VO); // 含有輸入格式錯誤的Item_category_VO物件,也存入req
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/emp/addEmp.jsp");
//					failureView.forward(req, res);
//					return;
//				}
//				
//				/***************************2.開始新增資料***************************************/
//				EmpService empSvc = new EmpService();
//				Item_category_VO = empSvc.addEmp(ename, job, hiredate, sal, comm, deptno);
//				
//				/***************************3.新增完成,準備轉交(Send the Success view)***********/
//				String url = "/emp/listAllEmp.jsp";
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
//				successView.forward(req, res);				
//		}
		
       
		if ("deletecart".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】

				/***************************1.接收請求參數***************************************/
				Integer my_cart_number = Integer.valueOf(req.getParameter("my_cart_number"));
				System.out.println(my_cart_number);
				
				/***************************2.開始刪除資料***************************************/
				Mycart_Service Mycart_Service = new Mycart_Service();
//				Mycart_VO Mycart_VO = Mycart_Service.getOneEmp(my_cart_number);
				Mycart_Service.DELETE(my_cart_number);
				

				String url = "/shoping-cart.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
		
//		if ("listEmps_ByCompositeQuery".equals(action)) { // 來自select_page.jsp的複合查詢請求
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//
//				
//				/***************************1.將輸入資料轉為Map**********************************/ 
//				//採用Map<String,String[]> getParameterMap()的方法 
//				//注意:an immutable java.util.Map 
//				Map<String, String[]> map = req.getParameterMap();
//				
//				Iterator<Map.Entry<String, String[]>> a = map.entrySet().iterator();
//				while(a.hasNext()) {
//					Map.Entry<String, String[]> entry = a.next();
//					String values = "";
//					for(int i = 0; i<entry.getValue().length;i++) {
//						values += values+entry.getValue()[i];
//					}
//					System.out.println(entry.getKey() + "-" + values);
//				}
//				
//				/***************************2.開始複合查詢***************************************/
//				Item_category_Service empSvc = new Item_category_Service();
//				List<Item_category_VO> list  = empSvc.getAll(map);
//				
//				/***************************3.查詢完成,準備轉交(Send the Success view)************/
//				req.setAttribute("listEmps_ByCompositeQuery", list); // 資料庫取出的list物件,存入request
//				RequestDispatcher successView = req.getRequestDispatcher("/emp/listEmps_ByCompositeQuery.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
//				successView.forward(req, res);
//		}		
	}
}

