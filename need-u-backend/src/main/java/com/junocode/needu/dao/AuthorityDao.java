package com.junocode.needu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.junocode.needu.entity.Authority;

@Repository
public class AuthorityDao {
	@Autowired
	private SqlSession session;

	public List<Authority> selectAuthorityByMid(String mid) {
		return session.selectList("AuthorityMapper.selectAuthorityByMid", mid);
	}
}