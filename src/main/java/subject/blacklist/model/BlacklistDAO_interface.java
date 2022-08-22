package subject.blacklist.model;

import java.util.*;
public interface BlacklistDAO_interface {
	  public void insert(BlacklistVO blacklistVO);
      public void update(BlacklistVO blacklistVO);
      public void delete(Integer blacklistnumber);
      public BlacklistVO findMemberserialnumber(Integer memberserialnumber);
      public BlacklistVO findAccount(String account);//新增
      public List<BlacklistVO> getAll();
      public List<BlacklistVO> getAllAndAccount();//新增
      //萬用複合查詢(傳入參數型態Map)(回傳 List)
//    public List<EmpVO> getAll(Map<String, String[]> map); 
	
}
