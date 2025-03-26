package com.valtech.training.ecommerce.vos;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.entities.Orders.Status;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.services.CustomerService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.services.OrderServiceImpl;

import jakarta.persistence.criteria.Order;

public class OrderVO {
	
	private long id;
	private String status ;
	private long custId;
	private List<Long> itemIds ; 
	private List<Integer> quantity;
	
	@Autowired
	static OrderService orderService ;
	
	@Autowired
	static CustomerService customerService;
	
	public OrderVO() {
		
	}
	
	

	public OrderVO(long id, String status, long custId, List<Long> itemIds, List<Integer> quantity) {
		this.id = id;
		this.status = status;
		this.custId = custId;
		this.itemIds = itemIds;
		this.quantity = quantity;
	}



	public OrderVO from(Orders o) {
		String orderStatus = o.getStatus().name();
		
		return new OrderVO(o.getId(), orderStatus, o.getCustomer().getId(), orderService.getListOfItemId(o.getLineItems()),orderService.getListOfQuantity(o.getLineItems()));
	}
	
	public Orders to(List<LineItems> lineItems) {
		Status st = Status.valueOf(status);
		Orders o = new Orders(st);
		o.setCustomer(customerService.getCustomer(custId).to());
		o.setLineItems(lineItems);
		return o;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public long getCustId() {
		return custId;
	}



	public void setCustId(long custId) {
		this.custId = custId;
	}



	public List<Long> getItemIds() {
		return itemIds;
	}



	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}



	public List<Integer> getQuantity() {
		return quantity;
	}



	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}



	public static OrderService getOrderService() {
		return orderService;
	}



	public static void setOrderService(OrderService orderService) {
		OrderVO.orderService = orderService;
	}
	
	
}
