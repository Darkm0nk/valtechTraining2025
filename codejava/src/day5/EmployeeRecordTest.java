package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment.EmployeeInfo.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er = new EmployeeRecord(1, "hu", 23, Gender.MALE, 120000, 1, 3);
		System.out.println(er);
		assertEquals(1, er.id());
		assertEquals("hu", er.name());
		assertEquals(Gender.MALE, er.gender());
		assertEquals(120000, er.salary());
		assertEquals(1, er.experience());
		assertEquals(3, er.level());
		EmployeeRecord er1 = new EmployeeRecord(1, "hu", 23, Gender.MALE, 120000, 1, 3);
		
		assertEquals(er.hashCode(),er1.hashCode());
		assertEquals(er, er1);
		
		EmployeeRecord er2 = new EmployeeRecord(1, "thu", 23, Gender.MALE, 120000, 1, 3);
		assertFalse(er.hashCode()==er2.hashCode());
		assertNotEquals(er, er2);
		
		assertEquals(3100, er.computeBonus());
	}

}
