package assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment.EmployeeInfo.Gender;

class EmployeeDAOTest {
		
	EmployeeDAO dao = new EmployeeDAOImpl();
	
	@Test
	void testInsert() {
		
		dao.save(new EmployeeInfo(1,"test",23,12000,Gender.MALE,5,2));
//		EmployeeInfo e = new EmployeeInfo(1,"Working",25,20000,Gender.FEMALE,2,3);
		
		
		
	}
	
	@Test
	void testGet() {
		EmployeeInfo e = dao.get(1);
		assertEquals(1, e.getId());
		assertEquals("Utsav1", e.getName());
		assertEquals(21, e.getAge());
		assertEquals(Gender.MALE, e.getGender());
		assertEquals(25000, e.getSalary());
		assertEquals(0, e.getLevel());
		assertEquals(0, e.getExp());
		assertTrue(dao.getAll().size()>0);
	}

	@Test
	void testUpdated() {
		
	dao.update(new EmployeeInfo(1,"Utsav1",21,25000,Gender.MALE,0,0));
//		
			
	}
	
	@Test
	void testDeleted() {
		dao.delete(1);
		
//		EmployeeInfo e = dao.delete(1);
		
			
	}
}
