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

import subject.service.BLMemberService;
import subject.vo.BLMemberVO;

@WebServlet("/administrator/blmember.do")
public class BLMemberController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");	
//		System.out.println("abc");
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer blacklistid = Integer.valueOf(req.getParameter("blacklistid"));
				
				/***************************2.開始查詢資料****************************************/
				BLMemberService blmemberSvc = new BLMemberService();
				BLMemberVO blmemberVO = blmemberSvc.getOneBLMember(blacklistid);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("blmemberVO", blmemberVO);         // 資料庫取出的froannVO物件,存入req
				String url = "/administrator/blmember/blmemberupdate.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			Integer blacklistid = Integer.valueOf(req.getParameter("blacklistid").trim());

//Integer admno = Integer.valueOf(req.getParameter("admno").trim());
//Integer admno = ((AdmBean)req.getSession().getAttribute("user")).getAdmid();				
				
//			String sellername = req.getParameter("sellername").trim();			
//			String membername = req.getParameter("membername").trim();		

			Integer memberstatus = Integer.valueOf(req.getParameter("memberstatus").trim());

			BLMemberVO blmemberVO = new BLMemberVO();
			blmemberVO.setBlacklistid(blacklistid);
//			blmemberVO.setSellername(sellername);
//			blmemberVO.setMembername(membername);
			blmemberVO.setMemberstatus(memberstatus);
			
			/***************************2.開始修改資料*****************************************/
			BLMemberService blmemberSvc = new BLMemberService();
			blmemberVO = blmemberSvc.updateBLMember(blacklistid,  memberstatus);//sellername, membername,
			/***************************3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("blmemberVO", blmemberVO);         // 資料庫取出的froannVO物件,存入req
			String url = "/administrator/blmemberall.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		
		}
	}

}
