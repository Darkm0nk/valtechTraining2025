package com.valtech.training.first.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Publisher {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pubSeq")
	@SequenceGenerator(name = "pubSeq", sequenceName = "pub_seq", allocationSize = 1)
	private int id;
	private String name;
	@OneToMany(mappedBy = "publisher", targetEntity = Book.class ,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Set<Book>books;
	
	public Publisher() {
		
	}
	
	
	public Publisher( String name) {

		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
