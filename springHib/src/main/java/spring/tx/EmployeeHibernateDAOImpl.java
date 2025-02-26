package spring.tx;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeHibernateDAOImpl implements EmployeeDAO{

	private SessionFactory sessionFactory;
	public void SessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void save(EmployeeInfo e) {
		new HibernateTemplate(sessionFactory).save(e);
		
	}

	@Override
	public void update(EmployeeInfo e) {
		new HibernateTemplate(sessionFactory).update(e);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}

	@Override
	public EmployeeInfo get(int id) {
		return new HibernateTemplate(sessionFactory).load(EmployeeInfo.class,id);	
	}

	@Override
	public List<EmployeeInfo> getAll() {
		return new HibernateTemplate(sessionFactory).find("from EmployeeInfo e");	
	}
	
	
}
