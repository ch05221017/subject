package subject.memberupdate.model;

import java.util.*;
public interface MemberupdateDAO_interface {
      public void update(MemberupdateVO memberupdateVO);
      public MemberupdateVO findByPrimaryKey(Integer memberserialnumber);
      public List<MemberupdateVO> getAll();
}
