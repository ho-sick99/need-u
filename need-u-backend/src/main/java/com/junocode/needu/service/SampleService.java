package com.junocode.needu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junocode.needu.dao.MemberDao;
import com.junocode.needu.entity.Member;

@Service
public class SampleService {
	
	@Autowired
	private MemberDao memberDao;
	
	public List<Member> selectTest() {
		return memberDao.selectAll();
	}
}
