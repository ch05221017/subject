package subject.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import subject.service.Sellerservice;
import subject.service.SellerserviceImpl;

import subject.service.impl.Itemservice;
import subject.vo.itemvo;
import web.vo.Seller;

@WebServlet("/sellers/sellerUpdateServlet")
public class SellerDataUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		session = req.getSession();

		if ("sellerUpdate".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
					
			Object sellID = session.getAttribute("sellID");
			
//			 sellID = Integer.valueOf(req.getParameter("seller_serial_number"));			
//			System.out.println("sellID: " + session.getAttribute("sellID"));						
//			Integer serialnumber = Integer.valueOf(req.getParameter("seller_serial_number"));		
			
			String account = req.getParameter("item_name");
			String accountReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (account == null || account.trim().length() == 0) {
				errorMsgs.add("帳號不能空白!");
			} else if (!account.trim().matches(accountReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("帳號只能是中、英文字母,且長度必需在2到10之間!");
			}

			String name = req.getParameter("company_name");
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("請填寫公司名稱！");
			}

			String password = req.getParameter("company_member_password");
			if (password == null || password.trim().length() == 0) {
				errorMsgs.add("請填寫密碼！");
			}

			String idnumber = req.getParameter("id_number");
			if (idnumber == null || idnumber.trim().length() == 0) {
				errorMsgs.add("請填寫統一編號！");
			}

			String email = req.getParameter("seller_email");
			if (email == null || email.trim().length() == 0) {
				errorMsgs.add("請填寫信箱！");
			}

			String holder = req.getParameter("company_holder");
			if (holder == null || holder.trim().length() == 0) {
				errorMsgs.add("請填寫負責人！");
			}

			String holderid = req.getParameter("company_holder_id");
			if (holderid == null || holderid.trim().length() == 0) {
				errorMsgs.add("請填寫負責人身分證字號！");
			}

			String phone = req.getParameter("seller_phone_number");
			if (phone == null || phone.trim().length() == 0) {
				errorMsgs.add("請填寫電話！");
			}

			String mainaddress = req.getParameter("seller_main_address");
			if (mainaddress == null || mainaddress.trim().length() == 0) {
				errorMsgs.add("請填寫主公司地址");
			}

			String branchaddress = req.getParameter("seller_branch_address");
			String description = req.getParameter("store_description");

			

			Seller seller = new Seller();	
//			session.setAttribute("sellID", seller.getSerialnumber());
			seller.setSerialnumber((Integer)sellID);
			seller.setName(name);
			seller.setAccount(account);
			seller.setPassword(password);			
			seller.setIdnumber(idnumber);
			seller.setEmail(email);
			seller.setHolder(holder);
			seller.setHolderid(holderid);
			seller.setPhone(phone);
			seller.setMainaddress(mainaddress);
			seller.setBranchaddress(branchaddress);
			seller.setDescription(description);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("seller", seller); // 含有輸入格式錯誤的seller物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/sellers/Seller.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			req.setAttribute("SellerUpdateMsg",null);
			Sellerservice sellerSvc;
			try {
				 sellerSvc = new SellerserviceImpl();				
				
				Integer status = sellerSvc.sellerUpdate(seller);
				if (status > 0) {
					req.setAttribute("SellerUpdateMsg", "更新成功");
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("seller", seller);
			String url = "/sellers/Seller.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交至商品詳細頁.jsp
			successView.forward(req, res);
		}
		
		

		if ("sellerGetForUpdate".equals(action)) { // 賣家帳戶管理連結中的更新請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
//				Integer serialnumber = Integer.valueOf(req.getParameter("seller_serial_number"));
				
				Object sellID = session.getAttribute("sellID");
				System.out.println("sellID: "+session.getAttribute("sellID"));
				
				
				/***************************2.開始查詢資料****************************************/
				
					SellerserviceImpl sellerSvc = null;
					try {
						sellerSvc = new SellerserviceImpl();
						} catch (NamingException e) {						
						e.printStackTrace();
					}
					Seller seller = sellerSvc.getsellerGetForUpdate((Integer) 1002);
			
				
				

				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("seller",seller );         // 資料庫取出的seller物件,存入req
				String url = "/sellers/Seller.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
				}
		
		
		
		
	}

}
