package com.valtech.training.resultservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuizResult {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "quiz_seq")
	@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq",allocationSize = 1)
	private long id;
	private long quizId;
	private int score;
	private long percentage;
	
	
	public QuizResult() {
		
	}
	
	
	
	public QuizResult(long quizId, int score, long percentage) {
		super();
		this.quizId = quizId;
		this.score = score;
		this.percentage = percentage;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getQuizId() {
		return quizId;
	}
	public void setQuizId(long quizId) {
		this.quizId = quizId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public long getPercentage() {
		return percentage;
	}
	public void setPercentage(long percentage) {
		this.percentage = percentage;
	}
	
	
	
}
