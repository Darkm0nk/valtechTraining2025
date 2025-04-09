package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Item;

public class ItemVO {

	private long id;
	private String name;
	private String description;
	private int currQuantity;
	int reOrderQuantity ;
	int maxQuantity;
	
	public ItemVO() {
		
	}

	public ItemVO(long id, String name, String description, int currQuantity, int reOrderQuantity, int maxQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.currQuantity = currQuantity;
		this.reOrderQuantity = reOrderQuantity;
		this.maxQuantity = maxQuantity;
	}
	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getId(), i.getName(), i.getDesc(), i.getCurrQuantity(), i.getReOrderQuantity(), i.getMaxQuantity());
	}
	
	public Item to() {
		Item i = new Item(name, description, currQuantity, reOrderQuantity, maxQuantity);
		i.setId(id);
		return i;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCurrQuantity() {
		return currQuantity;
	}

	public void setCurrQuantity(int currQuantity) {
		this.currQuantity = currQuantity;
	}

	public int getReOrderQuantity() {
		return reOrderQuantity;
	}

	public void setReOrderQuantity(int reOrderQuantity) {
		this.reOrderQuantity = reOrderQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	
}
