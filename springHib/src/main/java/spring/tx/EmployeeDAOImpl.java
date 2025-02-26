package spring.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.tx.EmployeeInfo.Gender;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
//	static block, constructor of class
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private Connection getConnection() throws SQLException{
//		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/training","postgres","postgress");
		return dataSource.getConnection();
	}

	@Override
	public void save(EmployeeInfo e) {
		new JdbcTemplate(dataSource).update("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID)VALUES (?,?,?,?,?,?,?)", e.getName(), e.getAge(), e.getGender().toString(), e.getSalary(), e.getExp(), e.getLevel(), e.getId());
//		try (Connection con = getConnection()){
//			PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE (NAME,AGE,GENDER,SALARY,EXPERIENCE,LEVEL,ID)VALUES (?,?,?,?,?,?,?)");
//			setValuesToPreparedStatement(e, ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Inserted :: "+rowsAffected);
//		} catch (Exception e2) {
//			throw new RuntimeException(e2);
//		}
	}

	private void setValuesToPreparedStatement(EmployeeInfo e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setFloat(4, e.getSalary());
		ps.setInt(5, e.getExp());
		ps.setInt(6, e.getLevel());
		ps.setInt(7, (int) e.getId());
	}

	@Override
	public void update(EmployeeInfo e) {
		new JdbcTemplate(dataSource).update("UPDATE EMPLOYEE SET NAME = ? ,AGE = ? ,GENDER = ? ,SALARY = ? ,EXPERIENCE = ? , LEVEL= ? WHERE ID = ?", e.getName(), e.getAge(), e.getGender().toString(), e.getSalary(), e.getExp(), e.getLevel(), e.getId());
//		try(Connection con = getConnection()){
//			PreparedStatement ps = con.prepareStatement("UPDATE EMPLOYEE SET NAME = ? ,AGE = ? ,GENDER = ? ,SALARY = ? ,EXPERIENCE = ? , LEVEL= ? WHERE ID = ?");
//			setValuesToPreparedStatement(e, ps);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("Rows Updated :: "+rowsAffected);
//
//		}catch (Exception e2) {
//			throw new RuntimeException(e2);
//		}
//		
	}

	@Override
	public void delete(int id) {
		
		new JdbcTemplate(dataSource).update("DELETE FROM EMPLOYEE WHERE ID = ?", id);
//		try(Connection con = getConnection()){
//			PreparedStatement ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
//			ps.setInt(1, id);
//			int rowsAffected = ps.executeUpdate();
//			System.out.println("rowsAffected::"+rowsAffected);
//		}catch (Exception e2) {
//			throw new RuntimeException(e2);
//		}
		
	}

	@Override
	public EmployeeInfo get(int id) {
		
		new JdbcTemplate(dataSource).queryForObject("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE ID =?",new Object[] {id},new EmployeeRowMapper());
//		try(Connection con = getConnection()){
//			PreparedStatement ps = con.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE WHERE ID =?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			//System.out.println("...");
//			if(rs.next()) {
//				EmployeeInfo e = populateEmployee(rs);
//				System.out.println(e);
//				return e;
//			}else {
//				new RuntimeException("No Employee with Id"+id+"Found.");
//			}
//		}catch (Exception e) {
//			throw new RuntimeException(e);
//		}
		return null;
	}

	private static class EmployeeRowMapper implements RowMapper<EmployeeInfo>{
		@Override
		public EmployeeInfo mapRow(ResultSet rs, int index) throws SQLException {
			
			return EmployeeInfo.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).build();
		}
	}
	
	private EmployeeInfo populateEmployee(ResultSet rs) throws SQLException {
			return EmployeeInfo.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(Gender.valueOf(rs.getString(4))).salary(rs.getFloat(5)).exp(rs.getInt(6)).level(rs.getInt(7)).build();
		
	}

	@Override
	public List<EmployeeInfo> getAll() {
		return new JdbcTemplate(dataSource).query("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE", new EmployeeRowMapper());
//		List<EmployeeInfo> emps = new ArrayList<EmployeeInfo>();
//		try (Connection con = getConnection()){
//			PreparedStatement ps = con.prepareStatement("SELECT ID, NAME, AGE, GENDER, SALARY, EXPERIENCE, LEVEL FROM EMPLOYEE");
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				emps.add(populateEmployee(rs));
//			}
//		} catch (Exception e) {
//			
//		}
//		return emps;
	}

}
