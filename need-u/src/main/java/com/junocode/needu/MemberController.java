package com.junocode.needu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junocode.needu.vo.MemberVo;
import com.junocode.needu.dao.MemberDao;

@RestController
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	// 회원 정보 출력

	// 회원가입
	@PostMapping("/sign_up")
	public String sign_up(@RequestBody MemberVo vo) {

		String msg = "";
		try {
			memberDao.insert(vo);
			msg += "member insert success";
		} catch (Exception e) {
			e.printStackTrace();
			msg += e;
		}

		return msg;
	}

	// 로그인
	@PostMapping("/sign_in")
	public Object sign_in(@RequestBody MemberVo vo) {
		System.out.println(vo);
		System.out.println(vo.getClass());

		MemberVo user = null;
		user = memberDao.selectOne(vo.getMid()); // 입력받은 mid와 동일한 아이디 db에서 탐색후 정보 반환
		
		if (user == null) { // 유저 정보가 존재하지 않을 경우
			return "User doesn't exist";
		} else {
			if (user.getPassword().equals(vo.getPassword())) { // db 상의 비밀번호와 입력받은 비밀번호 일치할 경우
				return "success";
			} else { // 비밀번호가 일치하지 않을 경우
				return "Passwords do not match";
			}
		}

	}

}
