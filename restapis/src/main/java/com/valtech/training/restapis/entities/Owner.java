package com.valtech.training.restapis.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Owner {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "owner_seq")
	@SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq" , allocationSize = 1)
	private long id;
	private String name;
	private String mobile;
	private String email;
	@OneToMany(mappedBy = "owner",targetEntity = Watch.class,fetch = FetchType.EAGER)
	Set<Watch> watches;
	
	public Owner() {
		
	}

	public Owner( String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	
	public void removeWatch(Watch w) {
		w.setOwner(null);
		watches.remove(w);
			
	}
	
	public void addWatch(Watch w) {
		if(watches==null) watches = new HashSet<Watch>();
		watches.add(w);
		w.setOwner(this);
			
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Watch> getWatches() {
		return watches;
	}

	public void setWatches(Set<Watch> watches) {
		this.watches = watches;
	}
	
	
}
