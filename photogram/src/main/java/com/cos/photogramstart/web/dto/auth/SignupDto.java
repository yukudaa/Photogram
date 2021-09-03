package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

// 통신을 할때 담아두는 오브젝트 : Dto
@Data // Getter, Setter
public class SignupDto {
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
