package com.valtech.training.registerservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.services.SubscriptionService;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionConrtoller {
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@PostMapping("/")
	public SubscriptionVO createSubscription(@RequestBody SubscriptionVO vo) {
		return subscriptionService.createSubscription(vo);
	}
	
	@GetMapping("/")
	public List<SubscriptionVO> getAllSubscription(){
		return subscriptionService.getAllSubscription();
	}
	
	@GetMapping("/{id}")
	public SubscriptionVO getSubscription(@PathVariable long id) {
		return subscriptionService.getSubscription(id);
	}
}
