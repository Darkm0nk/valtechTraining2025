package com.valtech.training.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Items {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private String description;
	private int qty;
	private int reorderQty;
	private int maxQty;
	
	public Items() {}
	
	public Items(String name, String description, int qty, int reorderQty, int maxQty) {
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reorderQty = reorderQty;
		this.maxQty = maxQty;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", description=" + description + ", qty=" + qty + ", reorder_qty="
				+ reorderQty + ", max_qty=" + maxQty + "]";
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
	public int getReorder_qty() {
		return reorderQty;
	}
	public void setReorder_qty(int reorder_qty) {
		this.reorderQty = reorder_qty;
	}
	public int getMax_qty() {
		return maxQty;
	}
	public void setMax_qty(int max_qty) {
		this.maxQty = max_qty;
	}
	
	
}
