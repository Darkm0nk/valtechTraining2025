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
		double totalSalByEmployeeLevel = EmployeeService.totalSalByEmployeeLevel(0, EmployeeInfo.emp);
		assertEquals(72000.0, totalSalByEmployeeLevel);
		System.out.println("sumEmployeeByLevel :: "+totalSalByEmployeeLevel);
		
		double totalSalByEmployeeGender = EmployeeService.totalSalByEmployeeGender(Gender.MALE, EmployeeInfo.emp);
		assertEquals(72000.0, totalSalByEmployeeGender);
		System.out.println("totalSalByEmployeeGender :: "+ totalSalByEmployeeGender);
		
		double totalSalByEmployeeNameContains = EmployeeService.totalSalByEmployeeNameContains("A", EmployeeInfo.emp);
		assertEquals(161000.0, totalSalByEmployeeNameContains);
		System.out.println("totalSalByEmployeeNameContains :: "+ totalSalByEmployeeNameContains);
		
		double totalSalByEmployeeLevelAndGender = EmployeeService.totalSalByEmployeeLevelAndGender(1, Gender.FEMALE, EmployeeInfo.emp);
		assertEquals(29000.0, totalSalByEmployeeLevelAndGender);
		System.out.println("totalSalByEmployeeLevelAndGender :: "+ totalSalByEmployeeLevelAndGender);
		
	}
	
	@Test
	void testMapByGender() {
		System.out.println("..........................................................");
		Map<Gender, List<EmployeeInfo>> listByGender = EmployeeService.employeeMapByGender(EmployeeInfo.emp);
		assertNotNull(listByGender);
		System.out.println("listByGender"+listByGender);
		Map<Gender,Double> sumByGender = EmployeeService.totalSalOfEmployeeMapByGender(EmployeeInfo.emp);
		assertEquals(177000.0, sumByGender.get(Gender.FEMALE));
		System.out.println("sumByGender"+sumByGender);
		
	}

}
