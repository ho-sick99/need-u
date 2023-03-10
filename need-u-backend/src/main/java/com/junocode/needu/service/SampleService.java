package com.junocode.needu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junocode.needu.dto.MemberDto;
import com.junocode.needu.mapper.MemberMapper;

@Service
public class SampleService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public List<MemberDto> selectTest() {
		return memberMapper.selectAll();
	}
}
