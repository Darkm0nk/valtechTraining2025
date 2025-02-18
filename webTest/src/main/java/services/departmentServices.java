package services;
import java.util.*;
import java.util.stream.Collectors;

import dao.EmployeeInfo;
public class departmentServices {

	public static List<EmployeeInfo> sortEmployees(List<EmployeeInfo> employeeList,String column, String order) {
        Comparator<EmployeeInfo> comparator = null;
        
        // Choose the comparator based on the selected column
        switch (column) {
            case "id":
                comparator = Comparator.comparing(EmployeeInfo::getId);
                break;
            case "name":
                comparator = Comparator.comparing(EmployeeInfo::getName);
                break;
            case "age":
                comparator = Comparator.comparing(EmployeeInfo::getAge);
                break;
            case "salary":
                comparator = Comparator.comparing(EmployeeInfo::getSalary);
                break;
            case "experience":
                comparator = Comparator.comparing(EmployeeInfo::getExp);
                break;
            case "gender":
                comparator = Comparator.comparing(EmployeeInfo::getGender);
                break;
            case "level":
                comparator = Comparator.comparing(EmployeeInfo::getLevel);
                break;
            default:
                throw new IllegalArgumentException("Invalid column: " + column);
        }

        // Reverse the comparator for descending order
        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }
       
        // Apply the comparator to sort the employee list
        List<EmployeeInfo> sortedList = employeeList.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        System.out.println("------------------------------------------------------------------------");
        System.out.println("sortedList:: "+sortedList);
        return sortedList;
    }
}