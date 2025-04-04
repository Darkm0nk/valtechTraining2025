package com.valtech.training.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "itemSeq")
	@SequenceGenerator(name = "itemSeq", sequenceName = "item_seq" , allocationSize = 1)
	private long id;
	private String name;
	private String description;
	private int currQuantity;
	private int reOrderQuantity;
	private int maxQuantity;
	
	public Item() {
		
	}

	public Item( String description, String name ,int currQuantity, int reOrderQuantity, int maxQuantity) {

		this.description = description;
		this.name = name;
		this.currQuantity = currQuantity;
		this.reOrderQuantity = reOrderQuantity;
		this.maxQuantity = maxQuantity;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		description = desc;
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

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", currQuantity=" + currQuantity
				+ ", reOrderQuantity=" + reOrderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}
	
	
	
	
}
