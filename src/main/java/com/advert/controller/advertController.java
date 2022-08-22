package com.advert.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.advert.model.advertDAO;
import com.advert.model.advertService;
import com.advert.model.advertVO;

import subject.vo.AdmBean;

@MultipartConfig
@WebServlet("/advert/advert.do")
public class advertController extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String actionAd = req.getParameter("actionAd");
		if ("getadImg".equals(actionAd)) {
			advertDAO dao = new advertDAO();
			String advertserialnumber = req.getParameter("adNo");
			if (advertserialnumber != null) {
				Integer ad = Integer.parseInt(advertserialnumber);
				advertVO vo = dao.findByPrimaryKey(ad);
				ServletOutputStream out = res.getOutputStream();
				out.write(vo.getAdvertphoto());
				out.flush();
				out.close();
			}
		}	
		
		String actionItem = req.getParameter("actionItem");
		if ("getitemImg".equals(actionItem)) {
			advertDAO dao = new advertDAO();
			String advertserialnumber = req.getParameter("itemNo");
			if (advertserialnumber != null) {
				Integer item = Integer.parseInt(advertserialnumber);
				advertVO vo = dao.findByItemPK(item);
				ServletOutputStream out = res.getOutputStream();
				out.write(vo.getPhoto());
				out.flush();
				out.close();
			}
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Update".equals(action)) { // Advert.jsp中的更新請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer advertserialnumber = Integer.valueOf(req.getParameter("advertserialnumber"));
				
				/***************************2.開始查詢資料****************************************/
				advertService advertSvc = new advertService();
				advertVO advertvo = advertSvc.getOneAdvert(advertserialnumber);	

				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("advertvo", advertvo);         // 資料庫取出的advertVO物件,存入req
				String url = "/advert/updateAdvert.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 updateAdvert.jsp
				successView.forward(req, res);
				}
		
		
		
			if ("insert".equals(action)) { // 來自新增addAdvert.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
				Integer adminserialnumber = ((AdmBean)req.getSession().getAttribute("user")).getAdmid();
			
				String advertdescription = req.getParameter("advertdescription");
				if (advertdescription == null || advertdescription.trim().length() == 0) {
					errorMsgs.add("廣告敘述請勿空白");
				}
				
				Integer itemserialnumber = null;
				try {
					itemserialnumber = Integer.valueOf(req.getParameter("itemserialnumber"));
				} catch (NumberFormatException e) {
					itemserialnumber = null;
					errorMsgs.add("商品編號請勿空白");
				}
				
				
				Part pic = req.getPart("advertphoto");
				InputStream is = pic.getInputStream();
				byte[] advertphoto = new byte[is.available()];
				is.read(advertphoto);

				advertVO advertvo= new advertVO();
				advertvo.setAdminserialnumber(adminserialnumber);
				advertvo.setAdvertdescription(advertdescription);
				advertvo.setAdvertphoto(advertphoto);
				advertvo.setItemserialnumber(itemserialnumber);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("advertvo", advertvo); // 含有輸入格式錯誤的advertVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/advert/addAdvert.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				advertService advertSvc = new advertService();
				advertvo = advertSvc.add(adminserialnumber, advertdescription, advertphoto, itemserialnumber);
			
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/advert/Advert.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交至商品詳細頁Advert.jsp
				successView.forward(req, res);	
		}
		
	
			if ("update".equals(action)) { // 來自更新商品頁的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);

					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					Integer adminserialnumber = ((AdmBean)req.getSession().getAttribute("user")).getAdmid();
					Integer advertserialnumber = Integer.valueOf(req.getParameter("advertserialnumber"));
					
					Integer itemserialnumber = null;
					try {
						itemserialnumber = Integer.valueOf(req.getParameter("itemserialnumber"));
					} catch (NumberFormatException e) {
						itemserialnumber = null;
						errorMsgs.add("商品編號請勿空白");
					}

					String advertdescription = req.getParameter("advertdescription");
					if (advertdescription == null || advertdescription.trim().length() == 0) {
						errorMsgs.add("廣告敘述請勿空白");
					}											
									
					Part pic = req.getPart("advertphoto");
					InputStream is = pic.getInputStream();
					byte[] advertphoto = new byte[is.available()];
					is.read(advertphoto);
					

					advertVO advertvo= new advertVO();
					advertvo.setAdvertserialnumber(advertserialnumber);
					advertvo.setAdminserialnumber(adminserialnumber);
					advertvo.setAdvertdescription(advertdescription);
					advertvo.setAdvertphoto(advertphoto);
					advertvo.setItemserialnumber(itemserialnumber);
					
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						req.setAttribute("advertvo", advertvo); // 含有輸入格式錯誤的advertVO物件,也存入req
						RequestDispatcher failureView = req
								.getRequestDispatcher("/advert/updateAdvert.jsp");
						failureView.forward(req, res);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					advertService advertSvc = new advertService();
					advertvo = advertSvc.update(advertserialnumber, adminserialnumber, advertdescription, advertphoto, itemserialnumber);
					
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					req.setAttribute("advertvo", advertvo);
					String url = "/advert/Advert.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交至商品詳細頁.jsp
					successView.forward(req, res);				
			}
			
	
			if ("delete".equals(action)) { // 來自Advert.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				req.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
				Integer advertserialnumber = Integer.valueOf(req.getParameter("advertserialnumber"));
					
					/***************************2.開始刪除資料***************************************/
					 advertService advertSvc = new advertService();
					 advertSvc.delete(advertserialnumber);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "/advert/Advert.jsp";
					RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(req, res);
			}		
	}
}
