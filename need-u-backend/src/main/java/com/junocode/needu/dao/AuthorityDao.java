package com.junocode.needu.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.junocode.needu.dto.AuthorityDto;



@Repository
public class AuthorityDao {
	@Autowired
	private SqlSession session;
	
	public AuthorityDto selectOne(String mid) {
		return session.selectOne("MemberMapper.selectOne", mid);
	}
}
