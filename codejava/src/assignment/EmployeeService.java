package assignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment.EmployeeInfo.Gender;

public class EmployeeService {

	public static double totalSalByEmployeeLevel(int level, List<EmployeeInfo> employeeByLevel) {
		return employeeByLevel.stream().filter(e->e.getLevel()== level).mapToDouble(EmployeeInfo :: getSalary).sum();
	}
	
	public static double totalSalByEmployeeGender(Gender gender, List<EmployeeInfo> employeeByGender) {
		return employeeByGender.stream().filter(e->e.getGender() == gender).mapToDouble(EmployeeInfo :: getSalary).sum();
	}
	
	public static double totalSalByEmployeeNameContains(String name, List<EmployeeInfo> employeeByNameContains) {
		return employeeByNameContains.stream().filter(e->e.getName().toLowerCase().contains(name.toLowerCase())).mapToDouble(EmployeeInfo:: getSalary).sum();
	}
	
	public static double totalSalByEmployeeLevelAndGender(int level, Gender gender , List<EmployeeInfo> employeeByLevelAndGender) {
		return employeeByLevelAndGender.stream().filter(e->e.getGender() == gender && e.getLevel()==level).mapToDouble(EmployeeInfo :: getSalary).sum();
	}
	
	
	public static Map<Gender,List<EmployeeInfo>> employeeMapByGender ( List<EmployeeInfo> employeeMapByGender){
		return employeeMapByGender.stream().collect(Collectors.groupingBy(EmployeeInfo::getGender));
	}
	public static Map<Gender, Double> totalSalOfEmployeeMapByGender ( List<EmployeeInfo> employeeMapByGender){
		return employeeMapByGender.stream().collect(Collectors.groupingBy(EmployeeInfo::getGender,Collectors.summingDouble(EmployeeInfo :: getSalary)));
	}
}
