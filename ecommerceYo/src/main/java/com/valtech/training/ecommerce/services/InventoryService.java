package com.valtech.training.ecommerce.services;



public interface InventoryService {

//	void createItem(Items i);

	// Update inventory quantity when an order is placed
	boolean updateInventory(Long itemID, int quantityOrdered);

	void setCurIfReq(long id);

}