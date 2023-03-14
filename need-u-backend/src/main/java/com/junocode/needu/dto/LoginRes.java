package com.junocode.needu.dto;

import lombok.Data;

@Data
public class LoginRes {
	private Boolean status;
	private TokenDto jwt;
	private String msg;
}
