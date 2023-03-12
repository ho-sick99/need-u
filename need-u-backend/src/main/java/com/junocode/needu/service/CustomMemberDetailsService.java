package com.junocode.needu.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junocode.needu.dao.AuthorityDao;
import com.junocode.needu.dao.MemberDao;
import com.junocode.needu.entity.Authority;
import com.junocode.needu.entity.Member;

@Service
public class CustomMemberDetailsService implements UserDetailsService {

	private final MemberDao memberDao;
	private final AuthorityDao authorityDao;

	public CustomMemberDetailsService(MemberDao memberDao, AuthorityDao authorityDao) {
		this.memberDao = memberDao;
		this.authorityDao = authorityDao;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String mid) throws UsernameNotFoundException {
		Member member = memberDao.selectOne(mid); // mid를 통해 member 객체 생성
		if (member == null) { // 멤버 존재하지 않음
			throw new UsernameNotFoundException("존재하지 않는 아이디입니다.");
		}
		return createUser(member); // 멤버 존재할 시 유저 객체 생성후 리턴
	}

//	   private org.springframework.security.core.userdetails.User createUser(String username, User user) { // 유저 생성 메서드
//	      if (!user.isActivated()) { // 유저가 활성화되어있지 않음
//	         throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
//	      }
//l
//	      List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
//	              .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
//	              .collect(Collectors.toList());
//
//	      return new org.springframework.security.core.userdetails.User(user.getUsername(),
//	              user.getPassword(),
//	              grantedAuthorities); // 유저 아이디, 비밀번호와 권한을 통한 유저 객체 생성
	private User createUser(Member member) {

		List<GrantedAuthority> authority = (authorityDao.selectAuthorityByMid(member.getMid())).stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuthority())) // 고려
				.collect(Collectors.toList());// 해당 member의 권한 정보 반환
		return new User(member.getMid(), member.getPassword(), authority);
	}

}
