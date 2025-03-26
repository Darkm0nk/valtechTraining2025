package com.valtech.training.sprsecoauth2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.authorizeHttpRequests(req->req.anyRequest().authenticated());
		httpSecurity.oauth2Login(Customizer.withDefaults());
		return httpSecurity.build();
	}
}
