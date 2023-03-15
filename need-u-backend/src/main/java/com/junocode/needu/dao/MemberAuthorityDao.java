package com.junocode.needu.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.junocode.needu.entity.MemberAuthority;

@Repository
public class MemberAuthorityDao {

	private final SqlSession session;
	
	public MemberAuthorityDao(SqlSession session) {
		this.session = session;
	}
	
	public void insertMemberAuthority(MemberAuthority mauth) {
		session.insert("AuthorityMapper.insertMemberAuthority", mauth);
	}
}
