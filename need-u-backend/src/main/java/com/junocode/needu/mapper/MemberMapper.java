package com.junocode.needu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.junocode.needu.dto.MemberDto;

@Mapper
public interface MemberMapper {
	List<MemberDto> selectAll();
}
