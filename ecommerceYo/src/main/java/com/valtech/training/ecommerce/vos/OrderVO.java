package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

public record OrderVO(int id,long custId,long itemId ,int qty,String status) {

	@Autowired
	static OrderService orderService;
	
	public static OrderVO from(Orders order) {
		long customerId = order.getCustomer().getId();
		long ids = order.getLineItems().get(0).getItem().getId();
		int qty = order.getLineItems().get(0).getQty();
		return new OrderVO(order.getId(),customerId,ids,qty,order.getStatus().name());
	}
	
	public Orders to() {
		Status stats = Status.valueOf(status);
		return new Orders(stats);
	}
}
