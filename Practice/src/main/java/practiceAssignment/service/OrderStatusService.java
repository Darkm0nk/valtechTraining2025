package practiceAssignment.service;

import practiceAssignment.Orders.Status;

public interface OrderStatusService {

	Status checkOrderStatus(long orderId);

	Status SetNextOrderStatus(long orderId);

}