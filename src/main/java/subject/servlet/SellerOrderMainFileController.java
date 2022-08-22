package subject.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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

import subject.dao.itemdao;
import subject.vo.itemvo;

@WebServlet("/sellers/sellerOrderMain")

public class SellerOrderMainFileController extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// 用訂單流水編號查看訂單細項
		if ("getDetail_For_Display".equals(action)) { // 來自Order.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer orderserialnumber = Integer.valueOf(req.getParameter("orderserialnumber"));
			System.out.println(orderserialnumber);
			/*************************** 2.開始查詢資料 *****************************************/
			OrderMainFileService orderMainFileSvc = new OrderMainFileService();
			OrderMainFileVO OrderMainFileVO = orderMainFileSvc.getOneOrderMainFile(orderserialnumber);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("OrderMainFileVO", OrderMainFileVO); // 資料庫取出的orderMainFileVO物件,存入req
//			String url = ;

			req.getRequestDispatcher("/sellers/OrderDetail.jsp").forward(req, res); // 成功轉交 OrderDetail.jsp

		}

	}
}
