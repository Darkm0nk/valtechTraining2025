package com.valtech.training.ecommerce.services;

import com.valtech.training.ecommerce.vos.CustomerVO;

public interface CustomerService {

	CustomerVO addCustomer(CustomerVO customer);

	void deleteCustomer(CustomerVO customer);

	CustomerVO enableCustomer(CustomerVO cust);

	CustomerVO disableCustomer(CustomerVO cust);

}