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

import org.hibernate.internal.build.AllowSysOut;

import subject.service.FroannService;
import subject.vo.AdmBean;
import subject.vo.FroannVO;

@WebServlet("/administrator/froann.do")
public class FroannController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");	
//		System.out.println("abc");
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("froannno");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/froann/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer froannno = null;
				try {
					froannno = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/administrator/froann.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				FroannService froannSvc = new FroannService();
				FroannVO froannVO = froannSvc.getOneFroann(froannno);
				if (froannVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/administrator/froann.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("froannVO", froannVO); // 資料庫取出的froannVO物件,存入req
				String url = "/administrator/froann.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer froannno = Integer.valueOf(req.getParameter("froannno"));
				
				/***************************2.開始查詢資料****************************************/
				FroannService froannSvc = new FroannService();
				FroannVO froannVO = froannSvc.getOneFroann(froannno);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("froannVO", froannVO);         // 資料庫取出的froannVO物件,存入req
				String url = "/administrator/froann/froannupdate.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
Integer froannno = Integer.valueOf(req.getParameter("froannno").trim());

//Integer admno = Integer.valueOf(req.getParameter("admno").trim());
Integer admno = ((AdmBean)req.getSession().getAttribute("user")).getAdmid();				
				
String froanndesc = req.getParameter("froanndesc").trim();
				if (froanndesc == null || froanndesc.trim().length() == 0) {
					errorMsgs.add("內容請勿空白!");
				} 
				
				java.sql.Date froannsdate = null;
				try {
froannsdate = java.sql.Date.valueOf(req.getParameter("froannsdate").trim());
				} catch (IllegalArgumentException e) {
					froannsdate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入開始日期!");
				}
				
				java.sql.Date froannedate = null;
				try {
froannedate = java.sql.Date.valueOf(req.getParameter("froannedate").trim());
				} catch (IllegalArgumentException e) {
					froannedate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入結束日期!");
				}

Integer froannstatus = Integer.valueOf(req.getParameter("froannstatus").trim());
		
				FroannVO froannVO = new FroannVO();
				froannVO.setFroannno(froannno);
				froannVO.setAdmno(admno);
				froannVO.setFroanndesc(froanndesc);
				froannVO.setFroannsdate(froannsdate);
				froannVO.setFroannedate(froannedate);
				froannVO.setFroannstatus(froannstatus);
			

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("froannVO", froannVO); // 含有輸入格式錯誤的froannVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/administrator/froann/froannupdate.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				FroannService froannSvc = new FroannService();
				froannVO = froannSvc.updateFroann(froannno, admno, froanndesc, froannsdate, froannedate, froannstatus);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("froannVO", froannVO); // 資料庫update成功後,正確的的froannVO物件,存入req
				String url = "/administrator/froann.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求
//        	String aaa = req.getParameter("froanndesc");
//			System.out.println(aaa);
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

Integer admno = ((AdmBean)req.getSession().getAttribute("user")).getAdmid();
//			System.out.println("aaa");
			
//Integer admno = Integer.valueOf(req.getParameter("ename"));			//Integer會報錯
//			Integer admnoReg = "^[(\u4e00-\u9fa5)(0-9)]{1,3}$";
//			if (admno == null || admno.trim().length() == 0) {
//				errorMsgs.add("請勿空白");
//			} else if(!admno.trim().matches(admnoReg)) { //以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("只能是數字 , 且長度必需在1到3之間");
//            }
			
String froanndesc = req.getParameter("froanndesc").trim();
			if (froanndesc == null || froanndesc.trim().length() == 0) {
				errorMsgs.add("內容請勿空白!");
			} 
			
			java.sql.Date froannsdate = null;
			try {
froannsdate = java.sql.Date.valueOf(req.getParameter("froannsdate").trim());
			} catch (IllegalArgumentException e) {
				froannsdate=new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入開始日期!");
			}
			java.sql.Date froannedate = null;
			try {
froannedate = java.sql.Date.valueOf(req.getParameter("froannedate").trim());
			} catch (IllegalArgumentException e) {
				froannedate=new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入結束日期!");
			}

Integer froannstatus = Integer.valueOf(req.getParameter("froannstatus").trim());	
	
			FroannVO froannVO = new FroannVO();
			froannVO.setAdmno(admno);
			froannVO.setFroanndesc(froanndesc);
			froannVO.setFroannsdate(froannsdate);
			froannVO.setFroannedate(froannedate);
			froannVO.setFroannstatus(froannstatus);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("froannVO", froannVO); // 含有輸入格式錯誤的froannVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("./froann/froannadd.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				FroannService froannSvc = new FroannService();
				froannVO = froannSvc.addFroann( admno, froanndesc, froannsdate, froannedate, froannstatus);
						
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/administrator/froann.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer froannno = Integer.valueOf(req.getParameter("froannno"));
				
				/***************************2.開始刪除資料***************************************/
				FroannService froannnoSvc = new FroannService();
				froannnoSvc.deleteFroann(froannno);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/administrator/froann.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}

