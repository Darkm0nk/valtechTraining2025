package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.entities.LineItem;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.vos.OrderVO;

public interface OrderService {

	public boolean createOrder(OrderVO order);

//	List<Long> getListofLineItemsIds(List<LineItem> items);
//
//	List<Integer> getListofLineItemsQty(List<LineItem> items);
}
