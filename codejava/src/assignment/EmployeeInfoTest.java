package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import assignment.EmployeeInfo.Gender;

class EmployeeInfoTest {

	EmployeeInfo employee = EmployeeInfo.builder().id(1).name("Vishal").age(21).salary(23000).gender(Gender.MALE).level(0).build();
	EmployeeInfo employee1 = EmployeeInfo.builder().id(1).name("Vishal").age(21).salary(23000).gender(Gender.MALE).level(0).build();
	EmployeeInfo employee2 = EmployeeInfo.builder().id(1).name("Sakshi").age(23).salary(29000).gender(Gender.FEMALE).level(1).build();
	EmployeeInfo employee3 = EmployeeInfo.builder().id(1).name("Hemant").age(22).salary(26000).gender(Gender.MALE).level(0).build();
	EmployeeInfo employee4 = EmployeeInfo.builder().id(1).name("nananum").age(21).salary(30000).gender(Gender.FEMALE).level(2).build();
	EmployeeInfo employee5 = EmployeeInfo.builder().id(1).name("viryatap").age(21).salary(30000).gender(Gender.OTHER).level(3).build();
	
	@Test
	void testHashCode() {
		
//		System.out.println(employee);
		int hash = employee.hashCode();
		
		assertEquals(hash, employee1.hashCode());
		
		assertNotSame(employee, employee1);
		
		assertNotEquals(hash,employee2.hashCode());
		
	}
	
	@Test
	void testSort() {
		System.out.println("..........................................................");
		Collections.sort(EmployeeInfo.emp);
		System.out.println(EmployeeInfo.emp);
	}
	
	@Test
	void testGetEmployee() {
		System.out.println("..........................................................");
		double sumEmployeeByLevel = EmployeeInfo.getEmployeeByLevel(0, EmployeeInfo.emp);
		System.out.println("sumEmployeeByLevel :: "+sumEmployeeByLevel);
		
		double sumEmployeeByGender = EmployeeInfo.getEmployeeByGender(Gender.MALE, EmployeeInfo.emp);
		System.out.println("sumEmployeeByGender :: "+ sumEmployeeByGender);
		
		double sumEmployeeByNameContains = EmployeeInfo.getEmployeeByNameContains("A", EmployeeInfo.emp);
		System.out.println("sumEmployeeByNameContains :: "+ sumEmployeeByNameContains);
		
		double sumEmployeeByLevelAndGender = EmployeeInfo.getEmployeeByLevelAndGender(1, Gender.FEMALE, EmployeeInfo.emp);
		System.out.println("sumEmployeeByLevelAndGender :: "+ sumEmployeeByLevelAndGender);
		
	}
	
	@Test
	void testMapByGender() {
		System.out.println("..........................................................");
		Map<Gender, List<EmployeeInfo>> listByGender = EmployeeInfo.employeeMapByGender(EmployeeInfo.emp);
		System.out.println("listByGender"+listByGender);
		Map<Gender,Double> sumByGender = EmployeeInfo.employeeMapSumByGender(EmployeeInfo.emp);
		System.out.println("sumByGender"+sumByGender);
		
	}

}
