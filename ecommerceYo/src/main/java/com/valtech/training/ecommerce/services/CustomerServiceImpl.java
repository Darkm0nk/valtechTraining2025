package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.entities.Customer.CustomerStatus;
import com.valtech.training.ecommerce.repos.CustomerRepo;
import com.valtech.training.ecommerce.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO addCustomer(CustomerVO customer) {
		Customer c = customer.to();
		customerRepo.save(c);
		return CustomerVO.from(c);
	}
	
	@Override
	public void deleteCustomer(CustomerVO customer) {
		customerRepo.delete(customer.to());
	}
	
	@Override
	public CustomerVO enableCustomer(CustomerVO cust) {
		Customer c = cust.to();
		c.setCustStatus(CustomerStatus.ENABLED);
		customerRepo.save(c);
		return CustomerVO.from(c);
	}
	
	@Override
	public CustomerVO disableCustomer(CustomerVO cust) {
		Customer c = cust.to();
		c.setCustStatus(CustomerStatus.DISABLED);
		customerRepo.save(c);
		return CustomerVO.from(c);
	}
	
}
