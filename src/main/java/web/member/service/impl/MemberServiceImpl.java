package web.member.service.impl;

import java.security.MessageDigest;
import java.util.Objects;

import javax.naming.NamingException;

import web.member.dao.MemberDao;
import web.member.dao.impl.MemberDaoImpl;
import web.member.service.MemberService;
import web.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao;

	public MemberServiceImpl () throws NamingException {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public Member login(Member member) {
		String account = member.getAccount();
		String password = member.getPassword();
		password = encode(password);
		member.setPassword(password);
		System.out.println(account + " " + password);
		if (!checkValue(account) || !checkValue(password)) {
			System.out.println("帳號或密碼錯誤");
			return null;
		}
		member = dao.selectForLogin(member);
		return member;
	}
	
	@Override
	public Boolean checkAccount(String account) {

		Member member = new Member();
		member.setAccount(account);
		System.out.println(account);
		if (dao.selectAccount(member)!= null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Integer register(Member member) {
		String encode = member.getPassword();
		encode = encode(encode);
		member.setPassword(encode);
		System.out.println(member.getPassword());
		Integer status = dao.insert(member);
		return status;
	}
	
	@Override
	public Integer changePassword(Member member) {
		// 1. check if there is any null column in the not-null column
		if (!checkValue(member.getAccount())) {
			System.out.println("修改錯誤");
			return null;
		}
		String encode = member.getPassword();
		encode = encode(encode);
		member.setPassword(encode);
		System.out.println(member.getPassword());
		return dao.updatePassword(member);
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
