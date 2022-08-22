package subject.blacklist.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.blacklist.model.BlacklistService;
import subject.blacklist.model.BlacklistVO;

@WebServlet("/blacklist/blacklist.do")
public class BlacklistController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//原本			String str = req.getParameter("memberserialnumber"); 
//			if (str == null || (str.trim()).length() == 0) { // str==null防呆用
//				errorMsgs.add("請輸入會員流水編號");
//			}
////				 Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			Integer memberserialnumber = null;
//			try {
//				memberserialnumber = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("員工編號格式不正確");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
			
			String str = req.getParameter("account"); 
			if (str == null || (str.trim()).length() == 0) { // str==null防呆用
				errorMsgs.add("請輸入會員帳號");
			}
//				 Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist2.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			String account = null;
			try {
				account = String.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist2.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

//原本			/*************************** 2.開始查詢資料 *****************************************/
//			BlacklistService blacklistSvc = new BlacklistService();
//			BlacklistVO blacklistVO = blacklistSvc.getOneblacklist(memberserialnumber);
//			if (blacklistVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist.jsp");
//				failureView.forward(req, res);
//				return;// 程式中斷
//			}
//
//			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//			req.setAttribute("blacklistVO", blacklistVO); // 資料庫取出的empVO物件,存入req
//			String url = "/blacklist/listOneBlacklist.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
//			successView.forward(req, res);
//		}
		
		/*************************** 2.開始查詢資料 *****************************************/
		BlacklistService blacklistSvc = new BlacklistService();
		BlacklistVO blacklistVO = blacklistSvc.getAccount(account);
		if (blacklistVO == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/listAllBlacklist2.jsp");
			failureView.forward(req, res);
			return;// 程式中斷
		}

		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
		req.setAttribute("blacklistVO", blacklistVO); // 資料庫取出的empVO物件,存入req
		String url = "/blacklist/listOneBlacklist.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
		successView.forward(req, res);
	}

		
		
		

		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer blacklistnumber = Integer.valueOf(req.getParameter("blacklistnumber"));
//			System.out.println("blacklistnumber: "+blacklistnumber);
			/*************************** 2.開始查詢資料 ****************************************/
			BlacklistService blacklistSvc = new BlacklistService();
			BlacklistVO blacklistVO = blacklistSvc.getOneblacklist(blacklistnumber);
//			System.out.println("[BlackListVO]: " + blacklistVO);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("blacklistVO", blacklistVO); // 資料庫取出的empVO物件,存入req
			String url = "/blacklist/update_blacklist_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer blacklistnumber = Integer.valueOf(req.getParameter("blacklistnumber").trim());

			Integer serialnumber = null;
			try {
				serialnumber = Integer.valueOf(req.getParameter("serialnumber").trim());
			} catch (NumberFormatException e) {
				serialnumber = 0;
				errorMsgs.add("賣家流水編號請填數字.");
			}
			
			Integer memberserialnumber = null;
			try {
				memberserialnumber = Integer.valueOf(req.getParameter("memberserialnumber").trim());
			} catch (NumberFormatException e) {
				memberserialnumber = 0;
				errorMsgs.add("會員流水編號請填數字.");
			}

			Boolean blackliststatus = null;
			try {
				if (blackliststatus = true || false);

			} catch (NumberFormatException e) {

				errorMsgs.add("黑名單狀態請填true或false.");
			}
			
/*新增*/		String account = req.getParameter("account").trim();
			if (account == null || account.trim().length() == 0) {
				errorMsgs.add("職位請勿空白");
			}	
			
			

//			Boolean blackliststatus = null;
//			try {
//				blackliststatus = boolean.valueOf(req.getParameter("blackliststatus").trim());
//			} catch (NumberFormatException e) {
//				serialnumber = 0;
//				errorMsgs.add("會員流水編號請填數字.");
//			}

//			Integer serialnumber = req.getParameter("serialnumber");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (serialnumber == null || serialnumber.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!serialnumber.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }

//			String memberserialnumber = req.getParameter("memberserialnumber").trim();
//				if (memberserialnumber == null || memberserialnumber.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}	
//				
//				java.sql.Date hiredate = null;
//				try {
//			hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//
//				Double sal = null;
//				try {
//sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//
//				Double comm = null;
//				try {
//comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}

			BlacklistVO blacklistVO = new BlacklistVO();
			blacklistVO.setBlacklistnumber(blacklistnumber);
			blacklistVO.setSerialnumber(serialnumber);
			blacklistVO.setMemberserialnumber(memberserialnumber);
			blacklistVO.setBlackliststatus(true);
			blacklistVO.setAccount(account);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("blacklistVO", blacklistVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/update_blacklist_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			BlacklistService blacklistSvc = new BlacklistService();
			blacklistVO = blacklistSvc.updateBlacklist(blacklistnumber, serialnumber, memberserialnumber,
					blackliststatus, account);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("blacklistVO", blacklistVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/blacklist/listOneBlacklist.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
//
//				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

			Integer serialnumber = null;
			try {
				serialnumber = Integer.valueOf(req.getParameter("serialnumber").trim());
			} catch (NumberFormatException e) {
				serialnumber = 0;
				errorMsgs.add("賣家流水編號請填數字");
			}
			
			Integer memberserialnumber = null;
			try {
				memberserialnumber = Integer.valueOf(req.getParameter("memberserialnumber").trim());
			} catch (NumberFormatException e) {
				serialnumber = 0;
				errorMsgs.add("會員流水編號請填數字");
			}
						
			Boolean blackliststatus = true;
			try {
				
			} catch (NumberFormatException e) {
				
			}
			
/*新增*/		String account = req.getParameter("account");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (account == null || account.trim().length() == 0) {
				errorMsgs.add("會員帳號: 請勿空白");
			} else if(!account.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員帳號: 只能是英文字母、數字");
            }
			
			
//			Boolean blackliststatus = Boolean.valueOf("blackliststatus");
//			if (blackliststatus == null) {
//				errorMsgs.add("黑名單狀態請勿空白");
//			}

//String ename = req.getParameter("ename");
//				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (ename == null || ename.trim().length() == 0) {
//					errorMsgs.add("員工姓名: 請勿空白");
//				} else if(!ename.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
//				
//String job = req.getParameter("job").trim();
//				if (job == null || job.trim().length() == 0) {
//					errorMsgs.add("職位請勿空白");
//				}
//				
//				java.sql.Date hiredate = null;
//				try {
//hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
//				} catch (IllegalArgumentException e) {
//					hiredate=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
//				}
//				
//				Double sal = null;
//				try {
//sal = Double.valueOf(req.getParameter("sal").trim());
//				} catch (NumberFormatException e) {
//					sal = 0.0;
//					errorMsgs.add("薪水請填數字.");
//				}
//				
//				Double comm = null;
//				try {
//comm = Double.valueOf(req.getParameter("comm").trim());
//				} catch (NumberFormatException e) {
//					comm = 0.0;
//					errorMsgs.add("獎金請填數字.");
//				}
//				
//Integer deptno = Integer.valueOf(req.getParameter("deptno").trim());
//
			BlacklistVO blacklistVO = new BlacklistVO();
			blacklistVO.setSerialnumber(serialnumber);
//			blacklistVO.setMemberserialnumber(memberserialnumber);
			blacklistVO.setBlackliststatus(true);
			blacklistVO.setAccount(account); //新增

//
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("blacklistVO", blacklistVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/blacklist/addBlacklist.jsp");
				failureView.forward(req, res);
				return;
			}
//				
//				/***************************2.開始新增資料***************************************/
			BlacklistService blacklistSvc = new BlacklistService();
			blacklistVO = blacklistSvc.addBlacklist(serialnumber,memberserialnumber, blackliststatus, account);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/blacklist/listAllBlacklist2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs1 = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs1);

			/*************************** 1.接收請求參數 ***************************************/
			Integer blacklistnumber = Integer.valueOf(req.getParameter("blacklistnumber"));

			/*************************** 2.開始刪除資料 ***************************************/
			BlacklistService blacklistSvc = new BlacklistService();
			blacklistSvc.deleteblacklist(blacklistnumber);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/blacklist/listAllBlacklist2.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}

}
