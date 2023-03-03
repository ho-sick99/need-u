package com.junocode.needu.dto;

public class LoginDto {
	private String mid, password;

	public LoginDto() {
	}
	
	public LoginDto(String mid, String password) {
		this.mid = mid;
		this.password = password;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [mid=" + mid + ", password=" + password + "]";
	}

}
