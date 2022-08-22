package subject.dao;

import java.util.List;

import subject.vo.BLMemberVO;

public interface BLMemberDAO_interface {
	public void update(BLMemberVO blmemberVO);
	public BLMemberVO findByPrimaryKey (Integer blacklistid);
	public List<BLMemberVO> getAll();

}
