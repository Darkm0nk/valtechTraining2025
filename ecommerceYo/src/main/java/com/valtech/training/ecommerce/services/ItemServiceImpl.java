package com.valtech.training.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.ecommerce.entities.Items;
import com.valtech.training.ecommerce.entities.Orders;
import com.valtech.training.ecommerce.repos.ItemRepo;
import com.valtech.training.ecommerce.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepo itemRepo;
	
	@Override
	public ItemVO addOrUpdateItem(ItemVO itemVO) {
		Items item = itemVO.to();
		itemRepo.save(item);
		return itemVO.from(item);
	}
	
	@Override
	public void deleteItem(ItemVO itemVO) {
		itemRepo.delete(itemVO.to());
	}
	
	@Override
	public List<ItemVO> getAll(){
		System.out.println("----------");
		return itemRepo.findAll().stream().map(i -> ItemVO.from(i)).collect(Collectors.toList());
	}
	
	@Override
	public ItemVO getById(long id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}
	
	
}
