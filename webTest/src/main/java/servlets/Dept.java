package servlets;

import java.util.ArrayList;
import java.util.List;




public class Dept {
	

	private int Id;
	private String name;
	private String location;
	public static List<Dept> depts = new ArrayList<Dept>();
	public Dept() {}

	public Dept(int id, String name, String location) {
		super();
		Id = id;
		this.name = name;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Dept [Id=" + Id + ", name=" + name + ", location=" + location + "]";
	}

	public static departmentBuilder builder() {
		return new departmentBuilder(new Dept());
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public static List<Dept> getDept() {
		return depts;
	}

	public static void setDept(List<Dept> depts) {
		Dept.depts = depts;
	}


	public static class departmentBuilder{
		
		private Dept department;
		
		public departmentBuilder(Dept department) {
			this.department = department;
		}
		public Dept build() {
			depts.add(department);
			return department;
		}
		public departmentBuilder id(int id) {
			department.setId(id);
			return this;
		}
		public departmentBuilder name(String name) {
			department.setName(name);
			return this;
		}
		public departmentBuilder location(String location) {
			department.setLocation(location);
			return this;
		}
	}
	
}
