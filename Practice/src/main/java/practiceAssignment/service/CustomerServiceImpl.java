package practiceAssignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import practiceAssignment.Customer;
import practiceAssignment.Customer.CustStatus;
import practiceAssignment.CustomerDAO;

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public void addCustomer(Customer cust) {
		customerDAO.save(cust);
	}
	
	@Override
	public void removeCustomer(Customer cust) {
		customerDAO.delete(cust);
	}
	
	@Override
	public Customer enableCustStatus(Customer cust) {
		if(cust.getStatus()!= CustStatus.ENABLE)
			cust.setStatus(CustStatus.ENABLE);
		customerDAO.update(cust);
		return cust;
	}
	
	@Override
	public Customer disableCustStatus(Customer cust) {
		if(cust.getStatus()!= CustStatus.DISABLE)
			cust.setStatus(CustStatus.DISABLE);
		customerDAO.update(cust);
		return cust;
	}
	
	

	@Override
	public Customer getCustomer(long id) {
		return customerDAO.get(id);
		
	}

	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getAll();
	}
	
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
}
