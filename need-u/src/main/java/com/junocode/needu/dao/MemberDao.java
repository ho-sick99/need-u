package com.junocode.needu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.junocode.needu.vo.MemberVo;

@Repository 
public class MemberDao {
	@Autowired
	private SqlSession session;
	
	public void insert(MemberVo vo) {
		System.out.println(vo);
		session.insert("MemberMapper.insert", vo);
	}

	public List<MemberVo> selectAll() {
		return session.selectList("MemberMapper.selectAll");
	}

	public MemberVo selectOne(String mid) {
		return session.selectOne("MemberMapper.selectOne", mid);
	}

	public void update(MemberVo vo) {
		session.update("MemberMapper.update", vo);
	}

	public void delete(int no) {
		session.delete("MemberMapper.delete", no);
	}
}
