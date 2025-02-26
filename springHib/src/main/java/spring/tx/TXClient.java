package spring.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.EmployeeInfo.Gender;

public class TXClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx  = new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new EmployeeInfo(11,"Ten",11,10,Gender.MALE,10,10));
	
		es.getAll().forEach(e->System.out.println(e));
		ctx.close();
	}
	
}
