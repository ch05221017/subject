package com.advertisement_show.controller;

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
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advertisement_show.model.Advertisement_show_Service;
import com.advertisement_show.model.Advertisement_show_VO;
import com.item.model.Item_Service;
import com.item.model.Item_VO;
import com.item_category.model.Item_category_Service;
import com.item_category.model.Item_category_VO;

@WebServlet("/Advertisement_show_Servlet")
public class Advertisement_show_Servlet extends HttpServlet {

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

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		  if ("VOUpdate".equals(action)) {
			  res.setContentType("image/jpeg");
			   ServletOutputStream out;
			   out = res.getOutputStream();
			   Integer advertisement_serial_number = Integer.valueOf(req.getParameter("No"));
			//   System.out.println(cruiseLineNo);
			   Advertisement_show_Service advertisement_service = new Advertisement_show_Service();
			   Advertisement_show_VO Advertisement_show_VO = advertisement_service.getOneEmp(advertisement_serial_number);
			//   byte[] img64 = Base64.encode(new String(cruiseLineVO.getCruiseLinePicture()));
			   out.write(Advertisement_show_VO.getAdvertisement_photo());
			  }
		
		
		if ("show_advertisement".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String item_serial_number = req.getParameter("item_serial_number");
				if (item_serial_number == null || (item_serial_number.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer item_serial_number1 = Integer.parseInt(item_serial_number);

				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				Item_Service empSvc = new Item_Service();
				Item_VO Item_VO = empSvc.getOneEmp(item_serial_number1);
				if (Item_VO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("Item_VO", Item_VO); // 資料庫取出的Item_category_VO物件,存入req
				String url = "/shopDtails_forad.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);
		}
		
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
		
       
//		if ("delete".equals(action)) { // 來自listAllEmp.jsp 或  /dept/listEmps_ByDeptno.jsp的請求
//
//			List<String> errorMsgs = new LinkedList<String>();
//			// Store this set in the request scope, in case we need to
//			// send the ErrorPage view.
//			req.setAttribute("errorMsgs", errorMsgs);
//			
//			String requestURL = req.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
//
//				/***************************1.接收請求參數***************************************/
//				Integer empno = Integer.valueOf(req.getParameter("empno"));
//				
//				/***************************2.開始刪除資料***************************************/
//				EmpService empSvc = new EmpService();
//				Item_category_VO Item_category_VO = empSvc.getOneEmp(empno);
//				empSvc.deleteEmp(empno);
//				
//				/***************************3.刪除完成,準備轉交(Send the Success view)***********/
//				DeptService deptSvc = new DeptService();
//				if(requestURL.equals("/dept/listEmps_ByDeptno.jsp") || requestURL.equals("/dept/listAllDept.jsp"))
//					req.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(Item_category_VO.getDeptno())); // 資料庫取出的list物件,存入request
//				
//				String url = requestURL;
//				RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功後,轉交回送出刪除的來源網頁
//				successView.forward(req, res);
//		}
		
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
