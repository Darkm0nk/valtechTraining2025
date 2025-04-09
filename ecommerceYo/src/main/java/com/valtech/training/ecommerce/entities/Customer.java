package com.valtech.training.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer_tbl")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	@Enumerated(EnumType.STRING)
	private CustomerStatus custStatus;
	
	public enum CustomerStatus{
		ENABLED,DISABLED
	}
	
	public Customer() {}
	
	public Customer(String name, int age, String address, String permanentAddress,CustomerStatus custStatus) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = permanentAddress;
		this.custStatus = custStatus;
	}
	
	public CustomerStatus getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(CustomerStatus custStatus) {
		this.custStatus = custStatus;
	}

//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", per_address="
//				+ permanentAddress + "]";
//	}

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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddresss(String per_address) {
		this.permanentAddress = per_address;
	}
	
	
}
