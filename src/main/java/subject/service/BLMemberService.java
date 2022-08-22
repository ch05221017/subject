package subject.service;

import java.util.List;

import subject.dao.BLMemberDAO;
import subject.dao.BLMemberDAO_interface;
import subject.vo.BLMemberVO;


public class BLMemberService {
	private BLMemberDAO_interface dao;
	
	public BLMemberService() {
		dao = new BLMemberDAO();
	}
	public BLMemberVO updateBLMember(
			Integer blacklistid,Integer memberstatus
//	String  sellername,String  membername,
			) {
		BLMemberVO blmemberVO = new BLMemberVO();
		
		blmemberVO.setBlacklistid(blacklistid);
//		blmemberVO.setSellername(sellername);
//		blmemberVO.setMembername(membername);
		blmemberVO.setMemberstatus(memberstatus);
		dao.update(blmemberVO);
		
		return blmemberVO;

	}
	
	public BLMemberVO getOneBLMember(Integer blacklistid) {
		return dao.findByPrimaryKey(blacklistid);
	}
	public List<BLMemberVO> getAll(){
		return dao.getAll();
	}
}
