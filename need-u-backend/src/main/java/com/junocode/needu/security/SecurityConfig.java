package com.junocode.needu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.junocode.needu.jwt.JwtAccessDeniedHandler;
import com.junocode.needu.jwt.JwtAuthenticationEntryPoint;
import com.junocode.needu.jwt.JwtSecurityConfig;
import com.junocode.needu.jwt.TokenProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {
	private final TokenProvider provider;
	private final JwtAuthenticationEntryPoint entryPoint;
	private final JwtAccessDeniedHandler handler;

	public SecurityConfig(TokenProvider provider, JwtAuthenticationEntryPoint entryPoint,
			JwtAccessDeniedHandler handler) {
		this.provider = provider;
		this.entryPoint = entryPoint;
		this.handler = handler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public WebSecurityCustomizer configure() {
		return (web) -> web.ignoring().antMatchers("/test/index", "/favicon.ico");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() // token을 사용하기 때문에 csrf disable

				.exceptionHandling().authenticationEntryPoint(entryPoint).accessDeniedHandler(handler)

				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				.and()

				.authorizeRequests().antMatchers("/test/hello").permitAll().antMatchers("/member/sign_up").permitAll()
				.antMatchers("/member/login").permitAll().anyRequest().authenticated()

				.and().formLogin().disable()
				
				.apply(new JwtSecurityConfig(provider));

		// token 방식이기 때문에 session STATELESS 설정

		return http.build();
	}
}
