package practiceAssignment;

import java.util.List;

public interface OrderDAO {

	void save(Orders o);
	void update(Orders o);
	void delete(Orders o);
	Orders get(long id);
	List<Orders> getAll();
}