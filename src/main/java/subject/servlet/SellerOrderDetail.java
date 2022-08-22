package subject.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import subject.dao.itemdao;
import subject.vo.itemvo;

@WebServlet("/sellers/sellerOrderDetail")
public class SellerOrderDetail extends HttpServlet{
	
		

		public void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			String action = req.getParameter("action");
			if ("getImg".equals(action)) {
				itemdao dao = new itemdao();
				String serialnumber = req.getParameter("itemNo");
				if (serialnumber != null) {
					Integer i1 = Integer.parseInt(serialnumber);
					itemvo vo = dao.findByPrimaryKey(i1);
					ServletOutputStream out = res.getOutputStream();
					out.write(vo.getPhoto());
					out.flush();
					out.close();
				}
			}
		
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			this.doGet(req, res);
//			req.setCharacterEncoding("UTF-8");
//			String action = req.getParameter("action");
			
			
			
			// 用訂單流水編號查看訂單細項
//			if ("getDetail_For_Display".equals(action)) { // 來自Order.jsp的請求
//
//				List<String> errorMsgs = new LinkedList<String>();
//				req.setAttribute("errorMsgs", errorMsgs);
//
//					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//					Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
//					System.out.println(orderserialnumber);
//					/***************************2.開始查詢資料*****************************************/
//					OrderDetailService orderDetailSvc = new OrderDetailService();
//					OrderDetailVO orderDetailVO = orderDetailSvc.getOneOrderDetail(orderserialnumber);
//					/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//					req.setAttribute("orderDetailVO", orderDetailVO); // 資料庫取出的orderMainFileVO物件,存入req
//					String url = "/seller/OrderDetail.jsp";
//					
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 OrderDetail.jsp
//					successView.forward(req, res);
//			}
//			
//			
//			if ("getOne_For_Update".equals(action)) { // 來自listAllOrderMainFile.jsp的請求
//
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//				
//					/***************************1.接收請求參數****************************************/
//					Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
//					
//					/***************************2.開始查詢資料****************************************/
//					OrderMainFileService orderMainFileSvc = new OrderMainFileService();
//					OrderMainFileVO orderMainFileVO = orderMainFileSvc.getOneOrderMainFile(orderserialnumber);
//									
//					/***************************3.查詢完成,準備轉交(Send the Success view)************/
//					req.setAttribute("orderMainFileVO", orderMainFileVO);         // 資料庫取出的orderMainFileVO物件,存入req
//					String url = "/orderMainFile/update_orderMainFile_input.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_orderMainFile_input.jsp
//					successView.forward(req, res);
//			}
			
		}
			
	}



