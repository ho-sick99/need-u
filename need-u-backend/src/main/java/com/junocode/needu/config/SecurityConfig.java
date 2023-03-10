package com.junocode.needu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
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
			.authorizeRequests()
			.antMatchers("/test/hello").permitAll()
			.anyRequest().authenticated()
				.and()
			.formLogin().disable();

		return http.build();
	}
}
