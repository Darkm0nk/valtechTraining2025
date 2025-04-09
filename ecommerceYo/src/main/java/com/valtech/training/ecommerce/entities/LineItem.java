package com.valtech.training.ecommerce.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineseq")
	@SequenceGenerator(name = "lineseq",sequenceName = "line_seq",allocationSize = 1)
	private long id;
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders order;
	private int qty;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	private Items item;
	
	public LineItem() {}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", order=" + order + ", qty=" + qty + ", item=" + item + "]";
	}

	public LineItem(int qty) {
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	
	
}
