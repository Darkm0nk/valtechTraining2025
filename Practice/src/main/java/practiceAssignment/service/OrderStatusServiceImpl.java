package practiceAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;

import practiceAssignment.OrderDAO;
import practiceAssignment.Orders;
import practiceAssignment.Orders.Status;

public class OrderStatusServiceImpl implements OrderStatusService {
	
	@Autowired
	OrderDAO orderDAO;
	
	
	@Override
	public Status checkOrderStatus(long orderId) {
		System.out.println("OrderId for Check status:: "+orderId);
		Orders o = orderDAO.get(orderId);
		return o.getStatus(); 
	}
	
	@Override
	public Status SetNextOrderStatus(long orderId) {
		
		Status currentStatus = orderDAO.get(orderId).getStatus();
		
		Status[] status = Status.values();
		
		int currentStatusIndex = currentStatus.ordinal();
		int nextStatusIndex = currentStatusIndex;
		
		if(currentStatusIndex!=status.length-1)
		nextStatusIndex ++;
		
		Orders o = orderDAO.get(orderId);
		o.setStatus(status[nextStatusIndex]);
		orderDAO.update(o);
		
		return status[nextStatusIndex];
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
}


