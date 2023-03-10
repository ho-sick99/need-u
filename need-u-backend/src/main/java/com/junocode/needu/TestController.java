package com.junocode.needu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junocode.needu.dto.MemberDto;
import com.junocode.needu.service.SampleService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private SampleService sampleService;

	@GetMapping("/index")
	public String index() {
		List<MemberDto> memList = sampleService.selectTest();
		System.out.println("조회 테스트 : " + memList);
		return memList.toString();
	}

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello");
	}
}
