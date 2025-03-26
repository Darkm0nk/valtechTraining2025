package com.valtech.training.quiz.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Quiz {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
	private long id;
	private String username;
	private String topic;
	@OneToMany(mappedBy = "quiz")
	private List<QuestionResult> questionResults;
	
	public Quiz() {
		
	}
	
	
	
	public Quiz(long id, String username, String topic) {
		super();
		this.id = id;
		this.username = username;
		this.topic = topic;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUser() {
		return username;
	}
	public void setUser(String username) {
		this.username = username;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
}
