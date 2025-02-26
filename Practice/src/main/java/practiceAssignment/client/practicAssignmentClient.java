package practiceAssignment.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import practiceAssignment.Customer;
import practiceAssignment.Item;
import practiceAssignment.Orders;
import practiceAssignment.Orders.Status;

public class practicAssignmentClient {

	public static void main(String[] args) {
		
		SessionFactory sesFac = new AnnotationConfiguration().addAnnotatedClass(Orders.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
//		Customer c = new Customer("kon",21,"nasas","lasla");
		System.out.println("sdcAdasdasd:::");
		Customer cust = (Customer)ses.load(Customer.class, 1L);
//		System.out.println(c);
		
		Orders o = new Orders(Status.ORDERED);

		o.setCustomer(cust);
//		c.addOrder(o); 
		
//		System.out.println(c.getOrders());
//		ses.persist(c);
		ses.save(o); 
		tx.commit();
		ses.close();
		sesFac.close();
	}
}
