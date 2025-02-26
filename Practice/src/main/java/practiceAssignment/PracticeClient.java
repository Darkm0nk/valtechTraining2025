package practiceAssignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("practice.xml");
		System.out.println("-----------------------------------------------------------------------");
//		CustomerDAOImpl c = ctx.getBean(CustomerDAOImpl.class);
//		c.save(new Customer("Who",22,"lalach","hehh"));
//		Customer c1 = c.get(1);
//		System.out.println(c1.getAddress());
//		c1.setAddress("naMane");
//		System.out.println(c1.getAddress()+" "+c1.getAge()+" "+c1.getName()+" "+c1.getPerAddress()+" "+c1.getId());
//		c.update(c1);
		
		ItemDAOImpl i = ctx.getBean(ItemDAOImpl.class);
		i.save(new Item("Hellooo",4,5,10));
		ctx.close();
	}
}
