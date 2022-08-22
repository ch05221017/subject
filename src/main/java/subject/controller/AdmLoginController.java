package subject.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import subject.service.AdmService;
import subject.vo.AdmBean;

@WebServlet(
		urlPatterns={"/administrator/admlogin.controller"}		
)
public class AdmLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdmService admService;
	@Override
	public void init() throws ServletException {
		admService = new AdmService();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//接收資料
		String admname = request.getParameter("admname");
		String password = request.getParameter("password");
		
		
		
//驗證資料
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if(admname==null || admname.length()==0) {
			errors.put("admname", "請輸入帳號");
		}
		if(password==null || password.length()==0) {
			errors.put("password", "請輸入密碼");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			request.getRequestDispatcher(
					"/administrator/admlogin.jsp").forward(request, response);
			return;
		}
		
//呼叫model
		AdmBean bean = admService.login(admname, password);
		
//根據model執行結果，導向view
		if(bean==null) {
			errors.put("password", "登入失敗，再試一次");
			request.getRequestDispatcher(
					"/administrator/admlogin.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			
			String path = request.getContextPath();
			response.sendRedirect(path+"/administrator/admwelcome.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
