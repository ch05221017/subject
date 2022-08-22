package com.orderDetail.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.orderDetail.model.OrderDetailDAO;
import com.orderDetail.model.OrderDetailService;
import com.orderDetail.model.OrderDetailVO;
import com.orderMainFile.model.OrderMainFileService;
import com.orderMainFile.model.OrderMainFileVO;

@WebServlet("/OrderDetail/OrderDetail.img")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gson gs = new Gson();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		req.setCharacterEncoding("UTF-8");
//		// 重要
//		res.addHeader("Access-Control-Allow-Origin", "*");
//		PrintWriter out = res.getWriter();
		
		String action = req.getParameter("action");
		if ("getImg".equals(action)) {
			OrderDetailDAO dao = new OrderDetailDAO();
			String itemserialnumber = req.getParameter("itemNo");
			if (itemserialnumber != null) {
				Integer i1 = Integer.parseInt(itemserialnumber);
				OrderDetailVO vo = dao.findByOrderDetailPK(i1);
				ServletOutputStream out = res.getOutputStream();
				out.write(vo.getPhoto());
				out.flush();
				out.close();
			}
		}

	}
	
	//OrderDetailService detailSvc = new OrderDetailService();
	//List<OrderDetailVO> listOrderDetail = detailSvc.getAllOrderDetail();
	//String base64 = Base64.getEncoder().encodeToString(listOrderDetail.get(0).getPhoto());
	////System.out.println(listOrderDetail.get(0).getPhoto());
	////byte[] decoded = Base64.getDecoder().decode(listOrderDetail.get(0).getPhoto());
	//
	//// byte[] buf = IOUtils.toByteArray(); 
	//// this throws an exception, message and cause both null as above
	//
	////out.print(gs.toJson(listOrderDetail.get(0).getPhoto()));
	//out.print(base64);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
