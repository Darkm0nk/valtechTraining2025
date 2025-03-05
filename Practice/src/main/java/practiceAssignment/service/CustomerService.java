package practiceAssignment.service;

import java.util.List;

import practiceAssignment.Customer;

public interface CustomerService {

	void addCustomer(Customer cust);

	void removeCustomer(Customer cust);

	Customer enableCustStatus(Customer cust);

	Customer disableCustStatus(Customer cust);
	
	Customer getCustomer(long id);
	
	List<Customer> getCustomers();

}