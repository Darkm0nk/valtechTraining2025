package practiceAssignment;

import java.util.List;

public interface CustomerDAO {

	void save(Customer c);
	void update(Customer c);
	void delete(Customer c);
	Customer get(long id);
	List<Customer> getAll();
	
}