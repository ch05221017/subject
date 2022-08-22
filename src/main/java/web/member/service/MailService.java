package web.member.service;

public interface MailService {

	//  設定傳送郵件:至收信人的Email信箱,Email主旨,Email內容
	void sendMail(String recipients, String mailSubject, String mailBody);

	String getAuthCode();

}