package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration //IoC   
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화됨.
		http.csrf().disable();	// csrf 안함
		http.authorizeRequests()
			.antMatchers("/","/user/**","/image/**","/subscribe/**","comment/**").authenticated()
			.anyRequest().permitAll()
			.and()		// ↓로그인 창에 자동으로 가게
			.formLogin()
			.loginPage("/auth/sighin")
			.defaultSuccessUrl("/");
		// 너가 "/","/user/**","/image/**","/subscribe/**","comment/**" 로 요청을 하면 "/auth/sighin"여기로 자동으로 가게 하겠다
	}	// 로그인처리가 정상적으로 되면 "/"로 가게할게

	
}
