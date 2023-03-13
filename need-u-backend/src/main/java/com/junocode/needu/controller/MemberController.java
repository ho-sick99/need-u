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

//	// 회원가입
//	@PostMapping("/sign_up")
//	public String sign_up(@RequestBody MemberDto vo) {
////
////		String msg = "";
////		try {
////			memberDao.insert(vo);
////			msg += "member insert success";
////		} catch (Exception e) {
////			e.printStackTrace();
////			msg += e;
////		}
////		
////		Map<String, Object> data = new HashMap<String, Object>();
////		data.put("msg", msg);
////
////		String resJson = "";
////		try {
////			resJson = new ObjectMapper().writeValueAsString(data);
////		} catch (JsonProcessingException e) {
////			e.printStackTrace();
////		}
////
////		return "signup";
//	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody LoginDto dto) {
		System.out.println(dto);
		TokenDto jwt = memberService.createToken(dto);
		System.out.println(jwt);
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt.getToken());

        return new ResponseEntity<>(jwt, httpHeaders, HttpStatus.OK);
//		System.out.println(dto);
//		System.out.println(dto);
//
//		Boolean res = false; // 로그인 성공 여부
//		String msg = ""; // 로그인 성공 여부 메시지
//		MemberDto user = null; // 유저 정보
//		// 서비스 코드
//		user = memberDao.selectOne(dto.getMid()); // 입력받은 mid와 동일한 아이디 db에서 탐색후 정보 반환
//
//		if (user == null) { // 유저 정보가 존재하지 않을 경우
//			msg += "User doesn't exist";
//		} else {
//			if (user.get.equals(dto.getPassword())) { // db 상의 비밀번호와 입력받은 비밀번호 일치할 경우
//				msg += "success";
//			} else { // 비밀번호가 일치하지 않을 경우
//				msg += "Passwords do not match";
//			}
//		}
//
//		Map<String, Object> data = new HashMap<String, Object>();
//		data.put("user", user);
//		data.put("msg", msg);
//
//		String resJson = "";
//		try {
//			resJson = new ObjectMapper().writeValueAsString(data);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//
//		// Bearer: (규약) JWT 혹은 OAuth에 대한 토큰을 사용한다. (RFC 6750)
//		
//		return "login";

		// }
	}

}