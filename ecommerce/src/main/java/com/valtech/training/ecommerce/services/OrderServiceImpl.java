package com.valtech.training.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Customer.CustStatus;
import com.valtech.training.ecommerce.entities.Item;
import com.valtech.training.ecommerce.entities.LineItems;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.repos.LineItemRepo;
import com.valtech.training.ecommerce.repos.OrderRepo;
import com.valtech.training.ecommerce.vos.LineItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

import jakarta.persistence.criteria.Order;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private ItemService itemService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String OrderProcess(OrderVO orderVO ,List<LineItemVO> lineitems) {
		if(orderVO.getStatus()=="DISABLE") return "Customer is Disable to place Order";
//		List<LineItems> lineItems = lineitems.stream().map(li->li.to(itemService.getItem(Integer.parseInt(li.itemId()))));
		List<LineItems> lineItems = new ArrayList<LineItems>();
		for (LineItemVO li : lineitems) {
			lineItems.add(li.to(itemService.getItem(Integer.parseInt(li.itemId())).to()));
		}
		Orders o = orderVO.to(lineItems);
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
			
			orderRepo.save(o);
//			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+o.getId());
//			lineItem.setOrder(o);
//			lineItemDAO.save(lineItem);
			 
			inventoryService.setCurIfReq(id);
		}
		
		return "Order Placed Successfully";
	}
	
	@Override
	public List<Long> getListOfItemId(List<LineItems> items){
		List<Long>itemIds = new ArrayList<Long>();
		for (LineItems i : items) {
			itemIds.add(i.getId());
			
		}
		return itemIds;
	}
	
	@Override
	public List<Integer> getListOfQuantity(List<LineItems> items){
		List<Integer> itemQuantity =new ArrayList<Integer>();
		for(LineItems i : items) {
			itemQuantity.add(i.getQuantity());
		}
		return itemQuantity;
	}
	
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
	
	
}
