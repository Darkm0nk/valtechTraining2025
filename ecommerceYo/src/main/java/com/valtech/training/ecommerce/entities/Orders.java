package com.valtech.training.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<LineItem> lineItems;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status{
		ORDERED,PACKED,SHIPPED,DELIEVERD,CANCELLED
	}
	
	public void addLineOrderItem(LineItem loi) {
		if(lineItems == null ) lineItems = new ArrayList<LineItem>();
		lineItems.add(loi);
		loi.setOrder(this);
	}
	
	public void removeLineOrderItem(LineItem loi) {
		lineItems.remove(loi);
		loi.setOrder(this);
	}
	
	public Orders() {}

	public Orders(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", lineItems=" + lineItems + ", status=" + status + "]";
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	

}
