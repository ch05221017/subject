package com.orderMainFile.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderDetail.model.OrderDetailService;
import com.orderDetail.model.OrderDetailVO;
import com.orderMainFile.model.OrderMainFileService;
import com.orderMainFile.model.OrderMainFileVO;

@WebServlet("/orderMainFile/orderMainFile.do")
public class OrderMainFileController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// FIXME context scope拿不到map
		// TODO　map的值應該來自DB
		Map<String, String> map = new HashMap<>();
		map.put("a", "已完成");
		getServletContext().setAttribute("orderStatus", map);
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		
		// 用訂單流水編號查看訂單細項
		if ("getDetail_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
				System.out.println(orderserialnumber);
				/***************************2.開始查詢資料*****************************************/
				OrderMainFileService orderMainFileSvc = new OrderMainFileService();
				OrderMainFileVO OrderMainFileVO = orderMainFileSvc.getOneOrderMainFile(orderserialnumber);
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("OrderMainFileVO", OrderMainFileVO); // 資料庫取出的orderMainFileVO物件,存入req
				String url = "/orderMainFile/ShowOrderDetail.jsp";
				
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 ShowOrderDetail.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自OrderMainFile.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
				
				/***************************2.開始查詢資料****************************************/
				OrderMainFileService orderMainFileSvc = new OrderMainFileService();
				OrderMainFileVO orderMainFileVO = orderMainFileSvc.getOneOrderMainFile(orderserialnumber);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("orderMainFileVO", orderMainFileVO);         // 資料庫取出的orderMainFileVO物件,存入req
				String url = "/orderMainFile/update_orderMainFile_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_orderMainFile_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_orderMainFile_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber").trim());
				Integer memberserialnumber = Integer.valueOf(req.getParameter("memberserialnumber").trim());
				Integer sellerserialnumber = Integer.valueOf(req.getParameter("sellerserialnumber").trim());
				String orderstatusnumber = String.valueOf(req.getParameter("orderstatusnumber").trim());
				Integer couponserialnumber = Integer.valueOf(req.getParameter("couponserialnumber").trim());
				Integer sellerevaluationstar = Integer.valueOf(req.getParameter("sellerevaluationstar").trim());
				Integer memberevaluationstar = Integer.valueOf(req.getParameter("memberevaluationstar").trim());
				String sellerevaluationdescription = String.valueOf(req.getParameter("sellerevaluationdescription").trim());
				String memberevaluationdescription = String.valueOf(req.getParameter("memberevaluationdescription").trim());
				Integer orderamount = Integer.valueOf(req.getParameter("orderamount").trim());
				java.sql.Date orderdate = java.sql.Date.valueOf(req.getParameter("orderdate").trim());
				
				OrderMainFileVO orderMainFileVO = new OrderMainFileVO();
				orderMainFileVO.setOrderserialnumber(orderserialnumber);
				orderMainFileVO.setMemberserialnumber(memberserialnumber);
				orderMainFileVO.setSellerserialnumber(sellerserialnumber);
				orderMainFileVO.setOrderstatusnumber(orderstatusnumber);
				orderMainFileVO.setCouponserialnumber(couponserialnumber);
				orderMainFileVO.setSellerevaluationstar(sellerevaluationstar);
				orderMainFileVO.setMemberevaluationstar(memberevaluationstar);
				orderMainFileVO.setSellerevaluationdescription(sellerevaluationdescription);
				orderMainFileVO.setMemberevaluationdescription(memberevaluationdescription);
				orderMainFileVO.setOrderamount(orderamount);
				orderMainFileVO.setOrderdate(orderdate);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("orderMainFileVO", orderMainFileVO); // 含有輸入格式錯誤的orderMainFileVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/orderMainFile/update_orderMainFile_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}				
				/***************************2.開始修改資料*****************************************/
				OrderMainFileService orderMainFileSvc = new OrderMainFileService();
				orderMainFileVO = orderMainFileSvc.updateOrderMainFile(orderserialnumber, memberserialnumber, sellerserialnumber, orderstatusnumber, couponserialnumber,sellerevaluationstar, memberevaluationstar,sellerevaluationdescription,memberevaluationdescription,orderamount,orderdate);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("orderMainFileVO", orderMainFileVO); // 資料庫update成功後,正確的的orderMainFileVO物件,存入req
				String url = "/orderMainFile/OrderMainFile.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneOrderMainFlie.jsp
				successView.forward(req, res);
		}
		
		
		if ("delete".equals(action)) { // 來自OrderMainFile.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
				
				/***************************2.開始刪除資料***************************************/
				OrderMainFileService orderMainFileSvc = new OrderMainFileService();
				orderMainFileSvc.deleteOrderMainFile(orderserialnumber);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/orderMainFile/OrderMainFile.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}

