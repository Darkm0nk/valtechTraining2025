package com.valtech.training.employee.services;

import java.util.List;

public interface EmployeeService {

	EmployeeVO saveOrUpdateEmployee(EmployeeVO e);

	EmployeeVO getEmployee(long id);

	List<EmployeeVO> getAllEmployee();

}