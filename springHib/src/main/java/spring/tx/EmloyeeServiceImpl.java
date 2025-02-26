package spring.tx;

import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
@Service
public class EmloyeeServiceImpl implements EmployeeService {
	@Autowired

	private EmployeeDAO employeeDAO;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(EmployeeInfo e) {
		employeeDAO.save(e);
//		throw new RuntimeException("Checking Rollback");
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(EmployeeInfo e) {
		employeeDAO.update(e);
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly(); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		employeeDAO.delete(id);
	}

	@Override
	public EmployeeInfo get(int id) {
		return employeeDAO.get(id);
	}

	@Override
	public List<EmployeeInfo> getAll() {
		return employeeDAO.getAll();
	}
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
}
