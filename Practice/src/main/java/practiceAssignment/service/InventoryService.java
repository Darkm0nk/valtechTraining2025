package practiceAssignment.service;

public interface InventoryService {

	Boolean checkCurrentItem(int quantity, long id);
	void setCurIfReq(long id);
}