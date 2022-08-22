package subject.ticket.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.item_category.model.Item_category_Service;
import com.item_category.model.Item_category_VO;
import com.order_detail.model.Order_detail_Service;
import com.order_detail.model.Order_detail_VO;




	@WebServlet("/qr_code")
	public class TicketController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
			
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");

//			if ("qr_code".equals(action)) { // 來自select_page.jsp的請求
//				System.out.println("abc");
//				List<String> errorMsgs = new LinkedList<String>();
//				// Store this set in the request scope, in case we need to
//				// send the ErrorPage view.
//				req.setAttribute("errorMsgs", errorMsgs);
//
//					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//					String str = req.getParameter("item_category_number");
//					if (str == null || (str.trim()).length() == 0) {
//						errorMsgs.add("請輸入員工編號");
//					}
//					// Send the use back to the form, if there were errors
//					if (!errorMsgs.isEmpty()) {
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/qr_code");
//						failureView.forward(req, res);
//						return;//程式中斷
//					}
//					
//					Integer item_category_number = Integer.parseInt(str);
//
//					
//					// Send the use back to the form, if there were errors
//					if (!errorMsgs.isEmpty()) {
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/select_page.jsp");
//						failureView.forward(req, res);
//						return;//程式中斷
//					}
//					
//					/***************************2.開始查詢資料*****************************************/
//					Item_category_Service empSvc = new Item_category_Service();
//					Item_category_VO Item_category_VO = empSvc.getOneEmp(item_category_number);
//					if (Item_category_VO == null) {
//						errorMsgs.add("查無資料");
//					}
//					// Send the use back to the form, if there were errors
//					if (!errorMsgs.isEmpty()) {
//						RequestDispatcher failureView = req
//								.getRequestDispatcher("/select_page.jsp");
//						failureView.forward(req, res);
//						return;//程式中斷
//					}
//					
//					/***************************3.查詢完成,準備轉交(Send the Success view)*************/
//					req.setAttribute("Item_category_VO", Item_category_VO); // 資料庫取出的Item_category_VO物件,存入req
//					String url = "/product_show.jsp";
//					RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
//					successView.forward(req, res);
//			}
			String str = req.getParameter("order_detail_serial_number");
			Integer order_detail_serial_number = Integer.parseInt(str);
			Order_detail_Service detailSvc = new Order_detail_Service();
			Order_detail_VO Order_detail_VO = detailSvc.getOneEmp(order_detail_serial_number);
			req.setAttribute("Order_detail_VO", Order_detail_VO); 
			
			String text = str;
			int width = 300;
			int height = 300;
			String format = "jpg";
			// 設定編碼格式與容錯率
			Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			// 設置QRCode的存放目錄、檔名與圖片格式
			String filePath = getServletContext().getRealPath("/qr_code_store");
			File dir = new File(filePath);     
	        
		    if (!dir.isDirectory()) {
		         dir.mkdir();
		    }
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()) + ".jpg";
			Path path = FileSystems.getDefault().getPath(filePath, fileName);
			// 開始產生QRCode
			BitMatrix matrix;
			try {
				matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
				MatrixToImageWriter.writeToPath(matrix, format, path);
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 把產生的QRCode存到指定的目錄
			System.out.println("path=" + path.toString());
			// 轉成Base64
			File file = new File(path.toString());
			InputStream input = new FileInputStream(file);
			String result = convert2Byte(input);
			System.out.println("result=" + result);
			req.setAttribute("fileName", req.getContextPath()+ "/qr_code_store/" + fileName); 
			req.setAttribute("filePath", filePath); 
			String a = req.getContextPath();
			System.out.println("a");
			System.out.println(a);
			String b = req.getServletContext().getRealPath("/qr_code_store");
			System.out.println("b");
			System.out.println(b);
			System.out.println("c");
			System.out.println(filePath);


				String url = "ticket/qrcode_button.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交listOneEmp.jsp
				successView.forward(req, res);
			
//				PrintWriter out = null;
	//
//				out.println("<br><img src=\""+request.getContextPath()+filePath+"/"+fileName+"\">");

			
			
			
			
//			file.delete();
		}
		private String convert2Byte(InputStream input) throws IOException {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buff = new byte[100];
			int length = 0;
			while ((length = input.read(buff, 0, 100)) > 0) {
				baos.write(buff, 0, length);
			}
			byte[] in2b = baos.toByteArray();
			baos.flush();
			baos.close();
			input.close();
			return new String(Base64.getEncoder().encodeToString(in2b));

		}

	
	
		
		}
