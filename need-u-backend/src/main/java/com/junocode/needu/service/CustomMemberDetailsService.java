package com.junocode.needu.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junocode.needu.dao.MemberDao;

@Service
public class CustomMemberDetailsService implements UserDetailsService {
	private final MemberDao memberDao;
	
	public CustomMemberDetailsService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	   @Transactional
	   public UserDetails loadUserByUsername(final String username) {
	      return userRepository.findOneWithAuthoritiesByUsername(username) // 유저 네임을 통해서 user 정보와 권한정보를 가져온다
	         .map(user -> createUser(username, user)) // username과 가져온 유저 정보를 통해서 유저 객체를 만든다
	         .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다.")); // 유저 정보가 없을 경우의 예외처리
	   }

	   private org.springframework.security.core.userdetails.User createUser(String username, User user) { // 유저 생성 메서드
	      if (!user.isActivated()) { // 유저가 활성화되어있지 않음
	         throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
	      }

	      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
	              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
	              .collect(Collectors.toList());

	      return new org.springframework.security.core.userdetails.User(user.getUsername(),
	              user.getPassword(),
	              grantedAuthorities); // 유저 아이디, 비밀번호와 권한을 통한 유저 객체 생성
	   }
	
}
