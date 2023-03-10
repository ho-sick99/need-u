package com.junocode.needu.jwt;

import java.io.Console;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
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
@PropertySource("classpath:application.yml")
public class TokenProvider implements InitializingBean {
	private static final String AUTHORITIES_KEY = "auth";

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
	public String createToken(Authentication authentication) {
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		long now = (new Date()).getTime();
		Date validDity = new Date(now + this.tokenValidityInSeconds); // 토큰 만료시간

		return Jwts.builder().setSubject(authentication.getName()).claim(AUTHORITIES_KEY, authorities)
				.signWith(key, SignatureAlgorithm.HS512).setExpiration(validDity).compact();
	}

	/**
	 * 토큰으로부터 권한 정보 반환 메서드
	 */
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

		Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		User principal = new User(claims.getSubject(), "", authorities);

		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}

	/**
	 * 토큰의 유효성 검증 수행 메서드
	 */
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			System.out.println(e);
			System.out.println("잘못된 JWT 서명");
		} catch(ExpiredJwtException e) {
			System.out.println(e);
			System.out.println("만료된 JWT 토큰");
		} catch(UnsupportedJwtException e) {
			System.out.println(e);
			System.out.println("지원되지 않는 JWT 토큰");
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("JWT 토큰이 잘못됨");
		}
		return false;
	}
}
