package com.valtech.training.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.services.UserManagerService;
import com.valtech.training.springsecurity.vos.UserVO;
import com.valtech.training.springsecurity.vos.changePasswordVO;


@Controller
public class AuthController {
	
	
	@Autowired
	private UserManagerService userService;
	
	@GetMapping("/changePassword")
	public String showChangePasswordForm() {
		return "changePassword";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@AuthenticationPrincipal User user, @ModelAttribute changePasswordVO changePassword) {
		userService.changePassword(user.getUsername(), changePassword);
		return "redirect:logout";
	}
	
	@GetMapping("/register")
	public String showRegisterForm() {
		return "register";
	}
	
	
	@PostMapping("/register")
	public String register(@ModelAttribute UserVO userVO) {
		userService.registerUser(userVO.to());
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user() {
		return "User";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin() {
		return "Admin";
	}
	
	
}
