package com.junocode.needu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junocode.needu.dto.LoginDto;
import com.junocode.needu.dto.LoginRes;
import com.junocode.needu.dto.MemberDto;
import com.junocode.needu.jwt.JwtFilter;
import com.junocode.needu.service.MemberService;
import com.junocode.needu.dto.TokenDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junocode.needu.dao.MemberDao;

@RestController
@RequestMapping("/member")
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 회원 정보 출력

	// 회원가입
	@PostMapping("/sign_up")
	public String sign_up(@RequestBody LoginDto dto) {
		return MemberService.sign_up();
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<LoginRes> login(@RequestBody LoginDto dto) {
		TokenDto jwt = memberService.createToken(dto);
		LoginRes loginRes = memberService.login(jwt);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt.getToken());

		return new ResponseEntity<>(loginRes, httpHeaders, HttpStatus.OK);
	}

}