package practiceAssignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LineItemDAOImpl implements LineItemDAO {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(LineItems l) {
		new HibernateTemplate(sessionFactory).save(l);
		
	}

	@Override
	public void update(LineItems l) {
		new HibernateTemplate(sessionFactory).update(l);
		
	}

	@Override
	public void delete(LineItems l) {
		new HibernateTemplate(sessionFactory).delete(l);
		
	}

	@Override
	public LineItems get(long id) {
		return new HibernateTemplate(sessionFactory).load(LineItems.class, id);
	}

	@Override
	public List<LineItems> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItems l");
	}

}
