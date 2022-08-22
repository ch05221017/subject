package subject.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import subject.dao.AdmDAO;
import subject.dao.AdmDAOJdbc;
import subject.vo.AdmBean;



public class AdmService {
	private AdmDAO admDao = new AdmDAOJdbc();
	public static void main(String[] args) { //測試用
		AdmService admService = new AdmService();
		AdmBean login = admService.login("luke", "777");
		System.out.println("login="+login);	
		
		boolean change = admService.changePassword(
				"luke", "777", "7");
		System.out.println("change="+change);	
	}
	public AdmBean login(String admname, String password) {
		AdmBean bean = admDao.select(admname);
		if(bean!=null) {
			// 比對Bean裡面的name及password，name已經比對過了
			if(password!=null && password.length()!=0) {
				String pass = bean.getPassword();
//				String temp = password.toString();
				if(pass.equals(password)) {
					return bean;
				}	
//				String action = req.getParameter("action");
//				if ("password".equals(action)) {
//					String password = req.getParameter("password");		
//			
			}
				
		}
		return null;
	}
	public boolean changePassword(String admname, String oldPassword, String newPassword) {
		AdmBean bean = this.login(admname, oldPassword);
		if(bean!=null) {
			
			return admDao.update(newPassword, admname);
		}
		return false;
	}
}
