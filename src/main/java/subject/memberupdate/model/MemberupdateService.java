package subject.memberupdate.model;
import java.util.List;

public class MemberupdateService {
	private MemberupdateDAO_interface dao;
	
	public MemberupdateService() {
		dao = new MemberupdateDAO();
	}

	public MemberupdateVO Memberupdate(Integer memberserialnumber, String name, String address,
			String email,String phone) {

		MemberupdateVO memberupdateVO = new MemberupdateVO();
		memberupdateVO.setMemberserialnumber(memberserialnumber);
		memberupdateVO.setName(name);
		memberupdateVO.setAddress(address);
		memberupdateVO.setEmail(email);
		memberupdateVO.setPhone(phone);
		dao.update(memberupdateVO);

		return memberupdateVO;
	}
	public MemberupdateVO getOneMemberupdate(Integer memberserialnumber) {
		return dao.findByPrimaryKey(memberserialnumber);
	}
	
	public List<MemberupdateVO> getAll() {
		return dao.getAll();
	}

}
