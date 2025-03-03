package practiceAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import practiceAssignment.Item;
import practiceAssignment.ItemDAO;
@Transactional(propagation = Propagation.SUPPORTS)
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	ItemDAO itemDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean checkCurrentItem(int quantity , long id) {
		
		Item i = itemDAO.get(id);
		System.out.println("Current Quantity in Item:: "+ i.getCurrQuantity()+" And Quantity:: "+quantity);
		if(i.getCurrQuantity()>quantity) {
			i.setCurrQuantity(i.getCurrQuantity()-quantity);
			System.out.println("Id of item in a list:: -------"+i.getCurrQuantity()); 
			itemDAO.save(i); 
			return true;
		}
		return false;
	}

	@Override
	public void setCurIfReq(long id) {
		
		Item i = itemDAO.get(id);

		if(i.getCurrQuantity()<i.getReOrderQuantity()) {
			i.setCurrQuantity(i.getMaxQuantity());
		}
	}
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
	
}
