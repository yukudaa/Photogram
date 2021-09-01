package com.cos.controllerdemo.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller // File을 응답하는 컨트롤러 (클라이언트가 브라우저면 .html파일을)
@RestController // Data를 응답하는 컨트롤러 (클라이언트가 핸드폰이면 data)
public class HttpController {

	// http://localhost:8080/get
	@GetMapping("/get")
	public String get() {
		return "<h1>get요청됨</h1>";
	}
	
	// http://localhost:8080/post
	@PostMapping("/post")
	public String post() {
		return "post요청됨";
	}
	
	// http://localhost:8080/put
	@PutMapping("/put")
	public String put() {
		return "put요청됨";
	}
	
	// http://localhost:8080/delete
	@DeleteMapping("/delete")
	public String delete() {
		return "delete요청됨";
	}
}
