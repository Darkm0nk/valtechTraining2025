package com.valtech.training.registerservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserVO>  getUser(@PathVariable long id) {
		try {
			return ResponseEntity.ok(userService.getUser(id)) ;
		} catch (EntityNotFoundException e) {
			return ResponseEntity.of(Optional.empty());
		}
		
	}
	
	@GetMapping("/")
	public List<UserVO> getAllUser(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/")
	public UserVO createUser(@RequestBody UserVO userVO) {
		return userService.createUser(userVO);
	}
	
	@PostMapping("/subscription/{sid}")
	public UserVO addUserToSubscription(@RequestBody UserVO userVO, @PathVariable("sid") long sid) {
		return userService.addUserToSubscription(userVO, sid);
	}
}
