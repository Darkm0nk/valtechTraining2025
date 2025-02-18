package assignment;

import java.util.List;

public interface EmployeeDAO {
	
	void save(EmployeeInfo e);
	
	void update(EmployeeInfo e);
	
	void delete(int id);
	
	EmployeeInfo get(int id);
	
	List<EmployeeInfo> getAll();
}
