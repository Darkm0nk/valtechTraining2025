package spring.aop.revision;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import spring.tx.EmployeeInfo;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public EmployeeInfo save(Session ses ,EmployeeInfo e) {
		long id = (Long) ses.save(e);
		return (EmployeeInfo)ses.load(EmployeeInfo.class, id);
	}

	@Override
	public EmployeeInfo get(Session ses, long id) {
		return(EmployeeInfo)ses.load(EmployeeInfo.class, id );
	}
	
	@Override
	public EmployeeInfo update(Session ses, EmployeeInfo e) {
		ses.update(e);
		return get(ses,e.getId());
	}
}
