package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
@Transactional(propagation =  Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public SubscriptionVO createSubscription(SubscriptionVO vo) {
		return SubscriptionVO.from(subscriptionRepo.save(vo.to(userRepo.findAll())));
	}
	
	@Override
	public SubscriptionVO getSubscription(long id) {
		return SubscriptionVO.from(subscriptionRepo.getReferenceById(id));
	}
	
	@Override
	public List<SubscriptionVO> getAllSubscription(){
		return subscriptionRepo.findAll().stream().map(sub->SubscriptionVO.from(sub)).collect(Collectors.toList());
	}
}
