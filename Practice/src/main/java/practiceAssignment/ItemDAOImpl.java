package practiceAssignment;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ItemDAOImpl implements ItemDAO {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Item i) {
		new HibernateTemplate(sessionFactory).merge(i);
	}

	@Override
	public void update(Item i) {
		new HibernateTemplate(sessionFactory).update(i);
	}

	@Override
	public void delete(Item i) {
		new HibernateTemplate(sessionFactory).delete(i);
		
	}

	@Override
	public Item get(long id) {
		return new HibernateTemplate(sessionFactory).load(Item.class, id);
	}

	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Item i");
	}

}
