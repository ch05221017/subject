package subject.blacklist.model;

import java.util.List;
public class BlacklistService {
	
	private BlacklistDAO_interface dao;

	public BlacklistService() {
		dao = new BlacklistDAO();
	}

	public BlacklistVO addBlacklist(Integer serialnumber, Integer memberserialnumber,Boolean  blackliststatus, String account) {

		BlacklistVO blacklistVO = new BlacklistVO();

		blacklistVO.setSerialnumber(serialnumber);
		blacklistVO.setMemberserialnumber(memberserialnumber);
		blacklistVO.setBlackliststatus(blackliststatus);
		blacklistVO.setAccount(account);
		dao.insert(blacklistVO);

		return blacklistVO;
	}

	public BlacklistVO updateBlacklist(Integer blacklistnumber,Integer serialnumber, Integer memberserialnumber, boolean blackliststatus,String account) {

		BlacklistVO blacklistVO = new BlacklistVO();

		blacklistVO.setBlacklistnumber(blacklistnumber);
		blacklistVO.setSerialnumber(serialnumber);
		blacklistVO.setMemberserialnumber(memberserialnumber);
		blacklistVO.setBlackliststatus(blackliststatus);
		blacklistVO.setAccount(account);
		dao.update(blacklistVO);

		return blacklistVO;
	}

	public void deleteblacklist(Integer blacklistnumber) {
		dao.delete(blacklistnumber);
	}

	public BlacklistVO getOneblacklist(Integer memberserialnumber) {
		return dao.findMemberserialnumber(memberserialnumber);
	}

	public BlacklistVO getAccount(String account) {
		return dao.findAccount(account); //新增
	}
	
	public List<BlacklistVO> getAll() {
		return dao.getAll();
	}
	public List<BlacklistVO> getAllAndAccount() {
		return dao.getAllAndAccount();
	}
	
}
