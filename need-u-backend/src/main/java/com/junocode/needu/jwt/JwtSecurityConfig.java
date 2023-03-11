package com.junocode.needu.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
	private TokenProvider provider;

	public JwtSecurityConfig(TokenProvider provider) {
		this.provider = provider;
	}

	@Override
	public void configure(HttpSecurity builder) throws Exception {
		JwtFilter filter = new JwtFilter(provider);
		builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
}
