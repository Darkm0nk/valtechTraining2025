package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.entities.Customer;
import com.valtech.training.ecommerce.vos.CustomerVO;

public interface CustomerService {

	CustomerVO addCustomer(CustomerVO cust);

	void removeCustomer(CustomerVO cust);

	CustomerVO enableCustStatus(CustomerVO cust);

	CustomerVO disableCustStatus(CustomerVO cust);
	
	CustomerVO getCustomer(long id);
	
	List<CustomerVO> getCustomers();

}