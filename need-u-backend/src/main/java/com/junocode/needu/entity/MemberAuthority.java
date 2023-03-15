package com.junocode.needu.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberAuthority {
	private String mid;
	private int authority_id;
}
