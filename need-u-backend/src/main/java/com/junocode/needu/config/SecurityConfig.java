package com.junocode.needu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web
				.ignoring()
				.antMatchers("/test/index");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // token을 사용하기 때문에 csrf disable
			.authorizeRequests()
			.antMatchers("/test/hello").permitAll()
			.anyRequest().authenticated()
			
			// token 방식이기 때문에 session STATELESS 설정
				.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.formLogin().disable();
			

		return http.build();
	}
}
