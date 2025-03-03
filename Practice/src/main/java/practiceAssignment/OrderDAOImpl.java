package practiceAssignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class OrderDAOImpl implements OrderDAO {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Orders o) {
		new HibernateTemplate(sessionFactory).merge(o);
	}

	@Override
	public void update(Orders o) {
		new HibernateTemplate(sessionFactory).update(o);
	}

	@Override
	public void delete(Orders o) {
		new HibernateTemplate(sessionFactory).delete(o);
	}

	@Override
	public Orders get(long id) {
		return new HibernateTemplate(sessionFactory).load(Orders.class, id);
	}

	@Override
	public List<Orders> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Orders o");
	}

}
