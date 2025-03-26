package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	  
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO userVO, long id) {
		return UserVO.from(userRepo.save(userVO.to(subscriptionRepo.getReferenceById(id))));
		
	}
	
	@Override
	public UserVO createUser(UserVO userVO) {
		Subscription subscription = new Subscription();
		subscription.setSubStart(LocalDate.now());
		subscription.setSubEnd(LocalDate.now().plusYears(1));
		subscription.setAmount(1000);
		subscriptionRepo.save(subscription);
		return UserVO.from(userRepo.save(userVO.to(subscription)));
		
	}
	
	@Override
	public List<UserVO> getAllUsers(){
		return userRepo.findAll().stream().map(u->UserVO.from(u)).collect(Collectors.toList());
	}
	
	@Override
	public UserVO getUser(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	public void deleteUserFromSubscription(long userId) {
		User user = userRepo.getReferenceById(userId);
		user.getSubscription().removeUser(user);
		userRepo.delete(user);
		 
	}
}
