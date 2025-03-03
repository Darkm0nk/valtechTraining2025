package com.valtech.training.first.entities;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Author {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authSeq")
	@SequenceGenerator(name = "authSeq" , sequenceName = "auth_seq" , allocationSize = 1)
	private int id ;
	private String name;
	private String Address;
	@ManyToMany(targetEntity = Book.class , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_author",joinColumns = @JoinColumn(name ="author_id", referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name ="book_id", referencedColumnName = "id"))
	private Set<Book> books;
	
	
	public Author() {
		
	}
	
	
	
	public Author(String name, String address) {
		super();
		this.name = name;
		Address = address;
	}


	
	public void addBook(Book b) {
		if(books == null) books = new HashSet<Book>();
		books.add(b);
		if(b.getAuthors()==null) b.setAuthors(new HashSet<Author>());
		b.getAuthors().add(this);
	}
	
	public void removeAuthor(Book b) {
		books.remove(b);
		b.getAuthors().remove(this);
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
