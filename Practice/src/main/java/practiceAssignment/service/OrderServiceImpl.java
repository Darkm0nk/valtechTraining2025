package practiceAssignment.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import practiceAssignment.Customer.CustStatus;
import practiceAssignment.Item;
import practiceAssignment.LineItemDAO;
import practiceAssignment.LineItems;
import practiceAssignment.OrderDAO;
import practiceAssignment.Orders;
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	@Autowired
	LineItemDAO lineItemDAO;
	@Autowired
	InventoryService inventoryService;
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String OrderProcess(Orders o) {
		if(o.getCustomer().getStatus()==CustStatus.DISABLE) return "Custmoer is Disable to place Order";
		Set<LineItems> lineItems = o.getLineItems();
		System.out.println("--------------------------------------------");
		System.out.println(lineItems);
		for(LineItems lineItem : lineItems) {
			int quantity = lineItem.getQuantity();
			System.out.println(lineItem);
			Item i = lineItem.getItem();
			lineItem.setOrder(o);
			long id = i.getId();

			Boolean ans = inventoryService.checkCurrentItem(quantity, id);
			if(!ans) {
				return "Item is out of stocks";
			}
			System.out.println("-----------------------------");
			
			orderDAO.save(o);
//			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+o.getId());
//			lineItem.setOrder(o);
//			lineItemDAO.save(lineItem);
			 
			inventoryService.setCurIfReq(id);
		}
		
		return "Order Placed Successfully";
	}
	
	
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void setLineItemDAO(LineItemDAO lineItemDAO) {
		this.lineItemDAO = lineItemDAO;
	}
}
