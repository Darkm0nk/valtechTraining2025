package spring.aop.revision;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.EmployeeInfo;
import spring.tx.EmployeeInfo.Gender;

public class TxAdviceClient {
	
	public static void main(String[] args) {
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("tx-advice.xml");
		EmployeeDAO dao = (EmployeeDAO)appCtx.getBean("employeeDAO");
		SessionFactory factory = appCtx.getBean(SessionFactory.class);
		dao.save(factory.openSession(), new EmployeeInfo(100, "TxGyu", 21, 100000, Gender.MALE, 2, 1));
	}
}
