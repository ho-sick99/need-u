package com.junocode.needu.service;

import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.junocode.needu.dao.MemberAuthorityDao;
import com.junocode.needu.dao.MemberDao;
import com.junocode.needu.dto.LoginDto;
import com.junocode.needu.dto.LoginRes;
import com.junocode.needu.dto.MemberDto;
import com.junocode.needu.dto.SignUpRes;
import com.junocode.needu.dto.TokenDto;
import com.junocode.needu.entity.Member;
import com.junocode.needu.entity.MemberAuthority;
import com.junocode.needu.jwt.TokenProvider;

@Service
public class MemberService {

	private final TokenProvider tokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final PasswordEncoder passwordEncoder;

	private final MemberDao memberDao;
	private final MemberAuthorityDao memberAuthorityDao;

	public MemberService(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder,
			PasswordEncoder passwordEncoder, MemberDao memberDao, MemberAuthorityDao memberAuthorityDao) {
		this.tokenProvider = tokenProvider;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.passwordEncoder = passwordEncoder;
		this.memberDao = memberDao;
		this.memberAuthorityDao = memberAuthorityDao;
	}

	public TokenDto createToken(LoginDto dto) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getMid(),
				dto.getPassword());

		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new TokenDto(tokenProvider.createToken(authentication));
	}

	public LoginRes login(TokenDto jwt) {
		LoginRes loginRes = new LoginRes();

		Boolean status;
		String msg;

		// 로그인 성공
		status = true;
		msg = "로그인 성공";

		loginRes.setStatus(true);
		loginRes.setJwt(jwt);
		loginRes.setMsg(msg);

		// 로그인 실패(구현예쩡)

		return loginRes;
	}

	public SignUpRes sign_up(MemberDto dto) throws DuplicateMemberException {
		System.out.println(dto);
		if (memberDao.selectOne(dto.getMid()) != null) { // DB에서 유저 정보 조회 실패 시
			throw new DuplicateMemberException("이미 가입되어 있는 유저입니다."); // 중복 유저 예외처리
		}

		MemberAuthority mauth = MemberAuthority.builder().mid(dto.getMid()).authority_id(1).build(); // 유저-권한 매핑 정보 객체
		Member member = Member.builder()
				.mid(dto.getMid())
				.nickname(dto.getNickname())
				.email(dto.getEmail())
				.password(passwordEncoder.encode(dto.getPassword())).build(); // 유저 정보 객체
		
		try { // DB 삽입
			memberAuthorityDao.insertMemberAuthority(mauth);
			memberDao.insert(member); 
		} catch (Exception e) { // 오류 처리
			e.printStackTrace();
		}

		SignUpRes signUpRes = new SignUpRes();

		Boolean status;
		String msg;

		// 회원가입 성공
		status = true;
		msg = "회원가입 성공";

		// 회원가입 실패(구현예정)

		signUpRes.setStstus(true);
		signUpRes.setMsg(msg);

		return signUpRes;
	}
}
