package practiceAssignment;

import java.util.List;


public interface ItemDAO {

	void save(Item i);
	void update(Item i);
	void delete(Item i);
	Item get(long id);
	List<Item> getAll();
}