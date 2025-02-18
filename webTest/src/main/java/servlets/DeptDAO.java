package servlets;

import java.util.List;

import dao.EmployeeInfo;


public interface DeptDAO {
	
	Dept first();
	Dept last();
	Dept next(int id);
	Dept prev(int id);

	void save(Dept dept);

	void update(Dept dept);

	void Delete(int id);

	Dept getDept(int id);

	List<Dept> getAll();
	
	List<EmployeeInfo> getEmployeeByDeptsId(int id);


}