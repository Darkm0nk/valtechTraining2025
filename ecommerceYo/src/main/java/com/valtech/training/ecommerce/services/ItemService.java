package com.valtech.training.ecommerce.services;

import java.util.List;

import com.valtech.training.ecommerce.vos.ItemVO;

public interface ItemService {

	ItemVO addOrUpdateItem(ItemVO itemVO);

	void deleteItem(ItemVO itemVO);

	List<ItemVO> getAll();

	ItemVO getById(long id);

}