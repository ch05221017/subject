package subject.memberupdate.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import subject.memberupdate.model.MemberupdateService;
import subject.memberupdate.model.MemberupdateVO;
import web.vo.*;
import web.member.dao.*;
import web.member.service.*;

@WebServlet("/memberupdate/memberupdate.do")
public class MemberupdateController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
//		Integer member = ((Integer) req.getAttribute("memID"));
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			String str = req.getParameter("memberserialnumber");
			if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入員工編號");
			}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req
					.getRequestDispatcher("/memberupdate/select_page.jsp");
			failureView.forward(req, res);
			return;//程式中斷
		}
		
		Integer memberserialnumber = null;
		try {
			memberserialnumber = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("員工編號格式不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req
					.getRequestDispatcher("/memberupdate/select_page.jsp");
			failureView.forward(req, res);
			return;//程式中斷
		}
		
		/***************************2.開始查詢資料*****************************************/
		MemberupdateService memberupdateSvc = new MemberupdateService();
		MemberupdateVO memberupdateVO = memberupdateSvc.getOneMemberupdate(memberserialnumber);
		if (memberupdateVO == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req
					.getRequestDispatcher("/memberupdate/select_page.jsp");
			failureView.forward(req, res);
			return;//程式中斷
		}
		
		/***************************3.查詢完成,準備轉交(Send the Success view)*************/
		req.setAttribute("memberupdateVO", memberupdateVO); // 資料庫取出的empVO物件,存入req
		String url = "/memberupdate/listOneMemberupdate.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
		successView.forward(req, res);
}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer memberserialnumber = Integer.valueOf(req.getParameter("memberserialnumber"));
				
				/***************************2.開始查詢資料****************************************/
				MemberupdateService memberupdateSvc = new MemberupdateService();
				MemberupdateVO memberupdateVO = memberupdateSvc.getOneMemberupdate(memberserialnumber);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("memberupdateVO", memberupdateVO);         // 資料庫取出的empVO物件,存入req
				String url = "/memberupdate/update_memberupdate_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer memberserialnumber = Integer.valueOf(req.getParameter("memberserialnumber").trim());
				
				
				String name = req.getParameter("name");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (name == null || name.trim().length() == 0) {
					errorMsgs.add("會員姓名: 請勿空白");
				} else if(!name.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String address = req.getParameter("address").trim();
				if (address == null || address.trim().length() == 0) {
					errorMsgs.add("地址請勿空白");
				}	
				
				String email = req.getParameter("email").trim();
				if (email == null || address.trim().length() == 0) {
					errorMsgs.add("電子郵件請勿空白");
				}	
				
				String phone = req.getParameter("phone").trim();
				if (phone == null || address.trim().length() == 0) {
					errorMsgs.add("電話號碼請勿空白");
				}	
//				String phone = req.getParameter("phone");
//				String phoneReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (phone == null || phone.trim().length() == 0) {
//					errorMsgs.add("電話號碼: 請勿空白");
//				} else if(!name.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("電話號碼: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//	            }
				
				

				MemberupdateVO memberupdateVO = new MemberupdateVO();
				memberupdateVO.setMemberserialnumber(memberserialnumber);
				memberupdateVO.setName(name);
				memberupdateVO.setAddress(address);
				memberupdateVO.setEmail(email);;
				memberupdateVO.setPhone(phone);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberupdateVO", memberupdateVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/memberupdate/update_memberupdate_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				MemberupdateService memberupdateSvc = new MemberupdateService();
				memberupdateVO = memberupdateSvc.Memberupdate(memberserialnumber, name, address, email, phone);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberupdateVO", memberupdateVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/memberupdate/listOneMemberupdate.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		
	}
}
