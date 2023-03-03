package com.junocode.needu.dto;

public class MemberDto {
	private String mid, nickname, email, password;

	public MemberDto() {
	}
	
	public MemberDto(String mid, String nickname, String email, String password) {
		this.mid = mid;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", nickname=" + nickname + ", email=" + email + ", password=" + password + "]";
	}

	
}
