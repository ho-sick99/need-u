package com.junocode.needu.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		Member member = memberDao.selectOne(mid);
		try {
			if (member == null) { // 멤버 존재하지 않음
				throw new UsernameNotFoundException(mid + " -> 데이터베이스에서 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return createUser(member); // 멤버 존재할 시 유저 객체 생성후 리턴
	}

	private User createUser(Member member) {
		List<GrantedAuthority> authority = (authorityDao.selectAuthorityByMid(member.getMid())).stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuthority_name())).collect(Collectors.toList()); // 해당

		return new User(member.getMid(), member.getPassword(), authority); // 유저 아이디, 비밀번호와 권한을 통한 유저 객체 생성
	}

}
