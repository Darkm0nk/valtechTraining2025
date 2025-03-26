package practiceAssignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practiceAssignment.Customer.CustStatus;
import practiceAssignment.Orders.Status;
import practiceAssignment.service.CustomerService;
import practiceAssignment.service.CustomerServiceImpl;
import practiceAssignment.service.OrderService;
import practiceAssignment.service.OrderServiceImpl;
import practiceAssignment.service.OrderStatusService;
import practiceAssignment.service.OrderStatusServiceImpl;

class PracticeAssignmentTest {

	@Test
	void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("practice.xml");
		System.out.println("-----------------------------------------------------------------------");
		CustomerService c = ctx.getBean(CustomerServiceImpl.class);
		c.addCustomer(new Customer("Who",22,"lalach","hehh",CustStatus.ENABLE));
		Customer c1 = c.getCustomer(11);
		System.out.println(c1.getAddress());
//		c1.setAddress("naMane");
//		System.out.println(c1.getAddress()+" "+c1.getAge()+" "+c1.getName()+" "+c1.getPerAddress()+" "+c1.getId());
//		c.update(c1);
		
		ItemDAO itemDAO = ctx.getBean(ItemDAOImpl.class);
//		Item i1  =i.get(2);
//		i.save(new Item("Hellooo",8,5,10));
		Customer c2 = c.getCustomer(12);
		System.out.println(c.disableCustStatus(c2).getStatus());
		
		Orders o = new Orders(Status.ORDERED);
		o.setCustomer(c1);
		
		
		Set<LineItems> addItems = new HashSet<LineItems>() ;
		System.out.println("---------------------------------------"+o);
		Item i1 = itemDAO.get(2);
		LineItems l1 = new LineItems(3);
		l1.setItem(i1);
		LineItems l2 = new LineItems(2);
		Item i2 = itemDAO.get(3);
		l2.setItem(i2);
		LineItems l3 = new LineItems(2);
		Item i3 = itemDAO.get(4);
		l3.setItem(i3);
		
		System.out.println( i1==i2);
		System.out.println("--------------------------------------");
		addItems.add(l1);
		addItems.add(l2);
		addItems.add(l3);
		System.out.println("++++++++++++++++++++++++++++++++++++++++"+addItems);
		assertTrue(!addItems.isEmpty());
		o.setLineItems(addItems);
		OrderService os = ctx.getBean(OrderServiceImpl.class);
		System.out.println(o);
		String result =os.OrderProcess(o);
		System.out.println(result);
		
		OrderStatusService orderStatusService = ctx.getBean(OrderStatusServiceImpl.class);
		
		System.out.println("Status of Order id 148 :: "+ orderStatusService.checkOrderStatus(148));
		assertEquals("DELIVERED", orderStatusService.checkOrderStatus(148).name());
//		i = new Item("Nothing",8,5,20);
//		iDAO.save(i);
		System.out.println("Set status next from :: "+orderStatusService.checkOrderStatus(148) +" to:: " +orderStatusService.SetNextOrderStatus(148));
		ctx.close();
		
//		assertEquals(os.OrderProcess(o), Item );
	}

}
