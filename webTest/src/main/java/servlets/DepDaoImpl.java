package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dao.EmployeeInfo;
import jakarta.servlet.ServletContext;


public class DepDaoImpl implements DeptDAO {

//	private Map<Integer,Dept> depts;
	
	ServletContext sc;
	public DepDaoImpl(ServletContext sc) {
		this.sc = sc;
	}
	
	
	public DepDaoImpl() {
	}


	private Connection getConnection(ServletContext sc) throws SQLException {
		String url = (String) sc.getAttribute("url");
		String user = (String) sc.getAttribute("user");
		String pass = (String) sc.getAttribute("pass");
		return DriverManager.getConnection(url,user,pass);
	}
//	public DepDaoImpl() {
//		depts = new HashMap<Integer, Dept>();
//	}
	@Override
	public void save(Dept dept) {
		try (Connection con = getConnection(this.sc)){
			PreparedStatement ps = con.prepareStatement("INSERT INTO DEPARTMENT (NAME, LOCATION, DEPARTMENT_ID) VALUES (?,?,?)");
			setValuesToPreparedStatement(dept, ps);
			
			int rawAffected = ps.executeUpdate();
			System.out.println("Raw Inserted :: "+rawAffected);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		depts.put(dept.getId(), dept);
	}
	
	@Override
	public void update(Dept dept) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement("UPDATE DEPARTMENT SET NAME =? , LOCATION=? WHERE DEPARTMENT_ID =? ");
			setValuesToPreparedStatement(dept, ps);
			
			int rawAffected = ps.executeUpdate();
			System.out.println("Raw Updated:: "+rawAffected);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		depts.put(dept.getId(), dept);
	}
	private void setValuesToPreparedStatement(Dept dept, PreparedStatement ps) throws SQLException {
		ps.setString(1, dept.getName());
		ps.setString(2, dept.getLocation());
		ps.setInt(3, dept.getId());
	}
	
	@Override
	public void Delete(int id) {
		try(Connection con = getConnection(this.sc)) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPARTMENT_ID = ?");
			ps.setInt(1, id);
			
			int rawAffected = ps.executeUpdate();
			System.out.println("Raw Deleted:: "+ rawAffected);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
//		depts.remove(id);
	}
	
	@Override
	public Dept getDept(int id) {
		try(Connection con = getConnection(this.sc)){
			PreparedStatement ps = con.prepareStatement("SELECT DEPARTMENT_ID, NAME, LOCATION FROM DEPARTMENT WHERE DEPARTMENT_ID = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Dept dept = populateDept(rs);
				System.out.println(dept);
				return dept;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
//		return depts.get(id);
	}
	
	private Dept populateDept(ResultSet rs) throws SQLException {
		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}
	
	private EmployeeInfo populateEmployee(ResultSet rs) throws SQLException {
		return EmployeeInfo.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(EmployeeInfo.Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).departmentId(rs.getInt(8)).build();
	
	}
	
	@Override
	public List<Dept> getAll(){
		
		List<Dept> departms = new ArrayList<Dept>();
		
		try (Connection con = getConnection(this.sc)){
			PreparedStatement ps = con.prepareStatement("SELECT DEPARTMENT_ID, NAME, LOCATION FROM DEPARTMENT");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				departms.add(populateDept(rs));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Depts in getAll ::"+departms);
		
		return departms;
	}
//	public Set<Dept> getAll() {
//		Set<Dept> all = new HashSet<Dept>();
//		for (int id : depts.keySet()) {
//			all.add(depts.get(id));
//		}
//		return all;
//	}
//	List<Dept> depts =  ;
	@Override
	public Dept first() {
		
		System.out.println("getAll List for Operatoions ... \n"+getAll());
		return getAll().stream().min((a,b)->(a.getId()-b.getId())).get();
//		return depts.get(depts.keySet().stream().min((a,b)->(a-b)).get());
	}

	@Override
	public Dept last() {
		return getAll().stream().max((a,b)->(a.getId()-b.getId())).get();
//		return depts.get(depts.keySet().stream().max((a,b)->(a-b)).get());
	}

	//whenever get a time - make it more appropriate
	@Override
	public Dept next(int id) {
		System.out.println("----------------------------------------");
		System.out.println("size of department in next ::"+ getAll().size());
		System.out.println("----------------------------------------");
		if(id == getAll().size()) return getDept(id);
		return getDept(id+1);
	}

	@Override
	public Dept prev(int id) {
		if(id==1) return getDept(id);
		return getDept(id-1);
	}
	@Override
	public List<EmployeeInfo> getEmployeeByDeptsId(int id) {
		List<EmployeeInfo> getEmployeebyDeptId = new ArrayList<EmployeeInfo>();
		try(Connection con = getConnection(this.sc)){
			PreparedStatement ps = con.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, DEPARTMENT_ID FROM EMPLOYEE WHERE DEPARTMENT_ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("it comes in while getEmployeeByDeptsId");
				getEmployeebyDeptId.add(populateEmployee(rs));
			}
		} catch (Exception e) {
			System.out.println("RuntimeException in getEmployeeByDeptsId ::  " + getEmployeebyDeptId);
			throw new RuntimeException();
		}
		return getEmployeebyDeptId;
	}
	
}
