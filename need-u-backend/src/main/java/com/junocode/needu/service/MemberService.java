package com.junocode.needu.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.junocode.needu.dto.LoginDto;
import com.junocode.needu.dto.TokenDto;
import com.junocode.needu.jwt.TokenProvider;

@Service
public class MemberService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    
    public MemberService(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
    	this.tokenProvider = tokenProvider;
    	this.authenticationManagerBuilder = authenticationManagerBuilder;
    }
    
	public TokenDto createToken(LoginDto dto) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getMid(), dto.getPassword());
		
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new TokenDto(tokenProvider.createToken(authentication));
	}
}
