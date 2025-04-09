package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderStatusService {
	

	@Autowired
	OrderRepo orderRepo;
	
	
	public Status checkStatus(long orderId) {
		Orders o = orderRepo.getReferenceById(orderId);
		return o.getStatus();
	}
	
	public Status updateStatus(long orderId) {
		System.out.println("Order id " +orderId);
		Status status = orderRepo.getReferenceById(orderId).getStatus();
		
		Status[] stats = Status.values();
		
		int curInd = status.ordinal();
		int nextInd = curInd;
		
		if(curInd != stats.length-1) {
			nextInd++;
		}
		
		Orders o = orderRepo.getReferenceById(orderId);
		o.setStatus(stats[nextInd]);
		orderRepo.save(o);
		return stats[nextInd];
	}
	
}
