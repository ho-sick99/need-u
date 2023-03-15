package com.junocode.needu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.junocode.needu.entity.Member;


@Repository 
public class MemberDao {
	private final SqlSession session;
	
	public MemberDao(SqlSession session) {
		this.session = session;
	}
	
	public void insert(Member member) {
		session.insert("MemberMapper.insert", member);
	}

	public List<Member> selectAll() {
		return session.selectList("MemberMapper.selectAll");
	}

	public Member selectOne(String mid) {
		return session.selectOne("MemberMapper.selectOne", mid);
	}

	public void update(Member vo) {
		session.update("MemberMapper.update", vo);
	}

	public void delete(int no) {
		session.delete("MemberMapper.delete", no);
	}

}
