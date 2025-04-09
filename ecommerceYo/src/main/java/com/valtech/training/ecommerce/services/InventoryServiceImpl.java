package com.valtech.training.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Items;
import com.valtech.training.ecommerce.repos.ItemRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	ItemRepo itemRepo;
//	@Override
//	public void createItem(Items i) {
//		dao.save(i);
//	}
	
	  // Update inventory quantity when an order is placed
    @Override
	public boolean updateInventory(Long itemID, int quantityOrdered) {
        Items existingItem = itemRepo.getReferenceById(itemID);
        if (existingItem != null && existingItem.getQty()>= quantityOrdered) {
            existingItem.setQty(existingItem.getQty() - quantityOrdered);
            itemRepo.save(existingItem);
            return true;
        }
//        else {
//        	existingItem.setQty(existingItem.getQty() + (quantityOrdered - existingItem.getQty()));
//        	dao.update(existingItem);
        	return false;
//        }
    }
  
    @Override
	public void setCurIfReq(long id) {
    	
    	Items i = itemRepo.getReferenceById(id);
    	if(i.getQty()<i.getReorder_qty()) {
    		i.setQty(i.getMax_qty());
    	}
    }
}
