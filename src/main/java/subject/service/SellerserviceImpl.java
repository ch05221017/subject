package subject.service;

import java.security.MessageDigest;
import java.util.Objects;

import javax.naming.NamingException;

import subject.dao.impl.SellerUpdateDao;
import subject.dao.impl.SellerUpdateDaoImpl;
import subject.vo.itemvo;
import web.vo.Seller;

public class SellerserviceImpl implements Sellerservice {
	private SellerUpdateDao dao;

	public SellerserviceImpl () throws NamingException{
		dao = new SellerUpdateDaoImpl();
	}
	
	
	@Override
	public  Integer sellerUpdate(Seller seller) {
		// 1. check if there is any null column in the not-null column
		if (!checkValue(seller.getName()) || !checkValue(seller.getIdnumber()) ||
				!checkValue(seller.getEmail()) || !checkValue(seller.getHolder()) ||
				!checkValue(seller.getHolderid()) || !checkValue(seller.getPhone())) {
			System.out.println("修改錯誤");
			return null;
		}
		String encode = seller.getPassword();
		encode = encode(encode);
		seller.setPassword(encode);
		System.out.println(seller.getPassword());
		dao.updateseller(seller);
//		return dao.updateseller(seller);
		return 1;
	}
	/**
     * 生成MD5
     * @param str
     * @return
     */
    public  String encode(String str) {
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
    
	public Seller getsellerGetForUpdate(Integer serialnumber) {
		return dao.selectByID(serialnumber);
	}

    
    
    
    
    

}