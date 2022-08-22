package web.seller.service.impl;

import java.security.MessageDigest;
import java.util.Objects;

import javax.naming.NamingException;

import web.seller.dao.SellerDao;
import web.seller.dao.impl.SellerDaoImpl;
import web.seller.service.SellerService;
import web.vo.Member;
import web.vo.Seller;

public class SellerServiceImpl implements SellerService {
	private SellerDao dao;

	public SellerServiceImpl () throws NamingException {
		dao = new SellerDaoImpl();
	}
	

	@Override
	public Seller login(Seller seller) {
		String account = seller.getAccount();
		String password = seller.getPassword();
		password = encode(password);
		seller.setPassword(password);
		System.out.println(account + " " + password);
		if (!checkValue(account) || !checkValue(password)) {
			System.out.println("帳號或密碼錯誤");
			return null;
		}
		seller = dao.selectForLogin(seller);
		return seller;
	}
	
	@Override
	public Boolean checkAccount(String account) {

		Seller seller = new Seller();
		seller.setAccount(account);
		System.out.println(account);
		if (dao.selectAccount(seller)!= null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Integer register(Seller seller) {
		String encode = seller.getPassword();
		encode = encode(encode);
		seller.setPassword(encode);
		System.out.println(seller.getPassword());
		Integer status = dao.insert(seller);
		return status;
	}
	
	@Override
	public Integer changePassword(Seller seller) {
		// 1. check if there is any null column in the not-null column
		if (!checkValue(seller.getAccount())) {
			System.out.println("修改錯誤");
			return null;
		}
		String encode = seller.getPassword();
		encode = encode(encode);
		seller.setPassword(encode);
		System.out.println(seller.getPassword());
		return dao.updatePassword(seller);
	}
	
	/**
     * 生成MD5
     * @param str
     * @return
     */
    public String encode(String str) {
        byte[] result = null;
        String algorithm = "MD5";
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes("UTF-8"));
            result = md.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }

    /**
     * 將二進位制轉換成十六進位制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
	
	
	private boolean checkValue(String value) {
		if (value == null || Objects.equals(value, "")) {
			System.out.println(value);
			return false;
		}
		return true;
	}
}
