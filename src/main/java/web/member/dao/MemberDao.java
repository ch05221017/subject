package web.member.dao;

import web.vo.Member;

public interface MemberDao {

	Integer insert(Member member);

	Integer delete(Member member);

	Member selectForLogin(Member member);

	Member selectEmail(Member member);

	Integer updatePassword(Member member);

	Member selectAccount(Member member);

	

}