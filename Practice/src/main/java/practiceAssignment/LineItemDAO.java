package practiceAssignment;

import java.util.List;

public interface LineItemDAO {
	
	void save(LineItems l);
	void update(LineItems l);
	void delete(LineItems l);
	LineItems get(long id);
	List<LineItems> getAll();
}