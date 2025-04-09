package com.valtech.training.quiz.entities;


import com.valtech.training.quiz.entities.Quiz;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class QuestionResult {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator = "qr_seq")
	@SequenceGenerator(name = "qr_seq",sequenceName = "qr_seq", allocationSize = 1)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_id" , referencedColumnName = "id")
	private Quiz quiz;
	private long questionId;
	private String userAnswer;
	private boolean result;
	
	
	
	public QuestionResult() {
		
	}
	
	
	
	public QuestionResult(long questionId, String userAnswer, boolean result) {
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.result = result;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public long getQuestion() {
		return questionId;
	}
	public void setQuestion(long questionId) {
		this.questionId = questionId;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	
	
}
