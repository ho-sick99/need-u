package com.junocode.needu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.junocode.needu.entity.Authority;

@Repository
public class AuthorityDao {
	private final SqlSession session;

	public AuthorityDao(SqlSession session) {
		this.session = session;
	}

	public List<Authority> selectAuthorityByMid(String mid) {
		return session.selectList("AuthorityMapper.selectAuthorityByMid", mid);
	}
}