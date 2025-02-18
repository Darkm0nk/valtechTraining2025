package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO{
//	static block, constructor of class
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgress");
	}

	@Override
	public void save(EmployeeInfo e) {
		try (Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,DEPARTMENT_ID,ID)VALUES (?,?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted :: "+rowsAffected);
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}
	}

	private void setValuesToPreparedStatement(EmployeeInfo e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, e.getDepartmentId());
		ps.setInt(8, (int) e.getId());
	}

	@Override
	public void update(EmployeeInfo e) {
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("UPDATE EMPLOYEE SET NAME = ? ,AGE = ? ,GENDER = ? ,SALARY = ? ,EXPERIENCE = ? , LEVEL= ? , DEPARTMENT_ID = ? WHERE ID = ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated :: "+rowsAffected);

		}catch (Exception e2) {
			throw new RuntimeException(e2);
		}
		
	}

	@Override
	public void delete(int id) {
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("rowsAffected::"+rowsAffected);
		}catch (Exception e2) {
			throw new RuntimeException(e2);
		}
		
	}

	@Override
	public EmployeeInfo get(int id) {
		try(Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, DEPARTMENT_ID FROM EMPLOYEE WHERE ID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//System.out.println("...");
			if(rs.next()) {
				EmployeeInfo e = populateEmployee(rs);
				System.out.println(e);
				return e;
			}else {
				new RuntimeException("No Employee with Id"+id+"Found.");
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	private EmployeeInfo populateEmployee(ResultSet rs) throws SQLException {
			return EmployeeInfo.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(EmployeeInfo.Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).departmentId(rs.getInt(8)).build();
		
	}

	@Override
	public List<EmployeeInfo> getAll() {
		List<EmployeeInfo> emps = new ArrayList<EmployeeInfo>();
		try (Connection con = getConnection()){
			PreparedStatement ps = con.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL, DEPARTMENT_ID FROM EMPLOYEE");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				emps.add(populateEmployee(rs));
			}
		} catch (Exception e) {
			
		}
		System.out.println("emps:: "+emps);
		return emps;
	}

}
