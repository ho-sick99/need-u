package com.junocode.needu.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {
	public static final String AUTHORIZATION_HEADER = "Authorization"; // 헤더명

	private TokenProvider tokenProvider;

	public JwtFilter(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String jwt = resolveToken(httpServletRequest); // jwt 토큰 추출
		String requestURL = httpServletRequest.getRequestURL().toString();
		
		if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
			Authentication authentication = tokenProvider.getAuthentication(jwt);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out
					.println("Security Context에 '" + authentication.getName() + "' 인증 정보를 저장했습니다, uri: " + requestURL);
		} else {
			System.out.println("유효한 JWT 토큰이 없습니다, uri:" + requestURL);
		}

		chain.doFilter(request, response);
	}

	/**
	 * Http 패킷에서 토큰 추출 메서드
	 * 
	 * @param request
	 * @return
	 */
	private String resolveToken(HttpServletRequest request) {
		String token = request.getHeader(AUTHORIZATION_HEADER); // Http 패킷 헤더에서 토큰 추출
		if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
			return token.substring(7); // 순수 토큰 값만 반환
		}
		return null; // 토큰이 없을 경우 null 반환
	}
}
