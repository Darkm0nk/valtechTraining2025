package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO createSubscription(SubscriptionVO vo);

	SubscriptionVO getSubscription(long id);

	List<SubscriptionVO> getAllSubscription();

}