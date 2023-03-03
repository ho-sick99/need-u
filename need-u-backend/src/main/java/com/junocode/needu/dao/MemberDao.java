package com.junocode.needu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.junocode.needu.dto.MemberDto;

@Repository 
public class MemberDao {
	@Autowired
	private SqlSession session;
	
	public void insert(MemberDto vo) {
		System.out.println(vo);
		session.insert("MemberMapper.insert", vo);
	}

	public List<MemberDto> selectAll() {
		return session.selectList("MemberMapper.selectAll");
	}

	public MemberDto selectOne(String mid) {
		return session.selectOne("MemberMapper.selectOne", mid);
	}

	public void update(MemberDto vo) {
		session.update("MemberMapper.update", vo);
	}

	public void delete(int no) {
		session.delete("MemberMapper.delete", no);
	}
}
