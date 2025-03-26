package hibernate.client;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import hibernative.Address;
import hibernative.AtmTx;
import hibernative.Car;
import hibernative.Customer;
import hibernative.TellerTx;
import hibernative.Tx;
import hibernative.chequeTx;

public class HibernateClient {
	
	public static void main(String[] args) {
		SessionFactory sesFac = new AnnotationConfiguration().addAnnotatedClass(Car.class).addAnnotatedClass(Tx.class).addAnnotatedClass(chequeTx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(AtmTx.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		
		Customer c = (Customer) ses.load(Customer.class, 1);
		System.out.println(c);
		System.out.println(c.getAddress());
//		Customer c = new Customer("ABC",23,true);
//		ses.save(c);
//		Address a =  new Address("Jayanagar","Blr",560078);
//		c.setAddress(a);
//		a.setCustomer(c);
//		a.setId(c.getId());
//		ses.saveOrUpdate(a);

//		ses.save(new Tx(1000));
//		ses.save(new chequeTx(3000,123456));
//		ses.save(new TellerTx(3000,"Admin","jayanagar"));
//		ses.save(new AtmTx(4000,123));
//		
//		List<Tx> txs = ses.createQuery("from Tx t").list();
//		System.out.println(txs);
//		Long id = (Long)ses.save(new Car(0,"BMW","M4",2023));
//		System.out.println(id);
//		Car car = (Car)ses.load(Car.class, id);
//		car.setName("Bmw");
//		ses.update(car);
//		System.out.println(car.getClass().getName());
		tx.commit();
		ses.close();
		sesFac.close();
	}
}
