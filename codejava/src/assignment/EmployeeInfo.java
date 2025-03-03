package assignment;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeInfo implements Comparable<EmployeeInfo>{
	
	private long id;
	private String name;
	private int age;
	private float salary;
	public Gender gender;
	private int level;
	private int exp;
	public static List<EmployeeInfo> emp = new ArrayList<EmployeeInfo>();
	public enum Gender{
		MALE, FEMALE, OTHER
	}
	
	public EmployeeInfo() {}

	public EmployeeInfo(long id, String name, int age, float salary, Gender gender, int level, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
		this.level = level;
		this.exp = exp;
	}




	

	@Override
	public String toString() {
		return new StringBuilder()
				.append(id)
				.append(" ")
				.append(name)
				.append(" ")
				.append(age)
				.append(" ")
				.append(salary)
				.append(" ")
				.append(gender)
				.append(" ")
				.append(level)
				.append(" ")
				.append(exp)
				.toString();
	}

	public static EmployeeBuilder builder() {
		return new EmployeeBuilder(new EmployeeInfo());
	}


	@Override
	public int hashCode() {
		return (toString()+"Employee").hashCode();
	}

	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EmployeeInfo))
			return false;
		EmployeeInfo employee = (EmployeeInfo) obj;
		return age == employee.age && exp == employee.exp && gender == employee.gender && id == employee.id && level == employee.level
				&& Objects.equals(name, employee.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(employee.salary);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int compareTo(EmployeeInfo other) {
		int levelComparision = Integer.compare(this.level,other.level);
		if(levelComparision!= 0) return levelComparision;
		
		int expComparision = Integer.compare(this.exp,other.exp);
		if(expComparision!= 0) return levelComparision;
		
		int genderComparision = this.gender.compareTo(other.gender);
		if(genderComparision!= 0) return genderComparision;
		
		return Double.compare(this.salary, other.salary);
	}

		
		

	public static class EmployeeBuilder{
		
		private EmployeeInfo employeeInfo;
		
		public EmployeeBuilder(EmployeeInfo employeeInfo) {
			this.employeeInfo = employeeInfo;
		}
		public EmployeeInfo build() {
			emp.add(employeeInfo);
			return employeeInfo;
		}
		public EmployeeBuilder id(long id) {
			employeeInfo.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			employeeInfo.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			employeeInfo.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary) {
			employeeInfo.setSalary(salary);
			return this;
		}
		public EmployeeBuilder gender(Gender gender) {
			employeeInfo.setGender(gender);
			return this;
		}
		public EmployeeBuilder level(int level) {
			employeeInfo.setLevel(level);
			return this;
		}
		public EmployeeBuilder exp(int exp) {
			employeeInfo.setExp(exp);
			return this;
		}
	}
	
}
