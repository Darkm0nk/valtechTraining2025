package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(long id, int amount, String subStart , String subEnd, List<Long> userIds) {

	public static final DateTimeFormatter FORMATTER =DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription subscription) {
		 
		String startDate = subscription.getSubStart().format(FORMATTER);
		String endDate = subscription.getSubEnd().format(FORMATTER);
		List<Long> ids = subscription.getUsers().stream().map(User::getId).collect(Collectors.toList());
		return new SubscriptionVO(subscription.getId(), subscription.getAmount(), startDate, endDate, ids);
	}
	
	public Subscription to(List<User> u) {
		LocalDate startDate = LocalDate.parse(subStart, FORMATTER);
		LocalDate startEnd = LocalDate.parse(subEnd, FORMATTER);
		Subscription s= new Subscription(amount, startDate, startEnd);
		s.setUsers(u);
		return s;
	}
}
