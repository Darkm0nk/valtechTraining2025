package com.valtech.training.registerservice.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_seq")
	@SequenceGenerator(name = "sub_seq",sequenceName = "sub_seq", allocationSize = 1)
	private long id;
	private int amount;
	private LocalDate subStart;
	private LocalDate subEnd;
	@OneToMany(mappedBy = "subscription", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = User.class)
	private List<User> users;

	public Subscription() {
		
	}

	public Subscription( int amount, LocalDate subStart, LocalDate subEnd ) {

		this.amount = amount;
		this.subStart = subStart;
		this.subEnd = subEnd;

	}
	
	public void addUser(User u) {
		if(users==null) {
			users = new ArrayList<User>();
		}
		users.add(u);
		u.setSubscription(this);
	
	}
	
	public void removeUser(User u) {
		users.remove(u);
		u.setSubscription(this);
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getSubStart() {
		return subStart;
	}

	public void setSubStart(LocalDate subStart) {
		this.subStart = subStart;
	}

	public LocalDate getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(LocalDate subEnd) {
		this.subEnd = subEnd;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
