package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO (long id, String name, String mobile, String email, boolean kid, long subId){

	public static UserVO from(User user) {
		return new UserVO(user.getId(), user.getName(), user.getMobile(), user.getEmail(), user.isKid() , user.getSubscription().getId());
	}
	
	public User to(Subscription subscription) {
		User user = new User(name, mobile, email, kid);
		user.setSubscription(subscription);
		return user;
	}
}
