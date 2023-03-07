package com.junocode.needu.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

// 확장 가능성을 위해 스프링 시큐리티를 이용한 권한 인증, 인가 관리

/**
 * 토큰 생성, 유효성 검증 담당
 *
 * @author JUNO
 *
 */
@Component
public class TokenProvider implements InitializingBean {
	private final String secret;
	private final long tokenValidityInSeconds;
	private Key key;

	public TokenProvider(@Value("${jwt.secret}") String secret,
			@Value("${jwt.token-validity-in-seconds}") long tokenValidityInSeconds) {
		this.secret = secret;
		this.tokenValidityInSeconds = tokenValidityInSeconds;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		byte[] keyBytes = Decoders.BASE64.decode(secret); // 주입받은 secret값을 base64 디코딩
		this.key = Keys.hmacShaKeyFor(keyBytes); // 필드에 할당
	}
	
	/**
	 * 토큰 생성 메서드
	 * 
	 * @return token
	 */
//	public String createToken() {
//		long now = (new Date()).getTime();
//		Date validDity = new Date(now + this.tokenValidityInSeconds); // 토큰 만료시간
//		
//		return Jwts.builder()
//				.setSubject()
//				.signWith(key, SignatureAlgorithm.HS512)
//				.setExpiration(validDity)
//				.compact();
//	}
	

}
