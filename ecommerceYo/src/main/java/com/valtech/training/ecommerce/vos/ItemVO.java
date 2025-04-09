package com.valtech.training.ecommerce.vos;

import com.valtech.training.ecommerce.entities.Items;

public class ItemVO {
	private long id;
	private String name;
	private String description;
	private int qty;
	private int reorderQty;
	private int maxQty;
	

	public ItemVO() {}

	public ItemVO(long id, String name, String description, int qty, int reorderQty, int maxQty) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reorderQty = reorderQty;
		this.maxQty = maxQty;
	}

	public static ItemVO from(Items i) {
		return new ItemVO(i.getId(),i.getName(),i.getDescription(),i.getQty(),i.getReorder_qty(),i.getMax_qty());
	}
	
	public Items to() {
		
		return new Items(name,description,qty,reorderQty,maxQty);
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}
	
	
}
