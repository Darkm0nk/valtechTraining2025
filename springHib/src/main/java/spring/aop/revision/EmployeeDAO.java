package spring.aop.revision;

import org.hibernate.Session;

import spring.tx.EmployeeInfo;

public interface EmployeeDAO {

	EmployeeInfo save(Session ses, EmployeeInfo e);

	EmployeeInfo get(Session ses, long id);

	EmployeeInfo update(Session ses, EmployeeInfo e);

}