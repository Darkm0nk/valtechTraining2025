package com.valtech.training.quiz.vos;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.quiz.entities.QuestionResult;
import com.valtech.training.quiz.entities.Quiz;
import com.valtech.training.quiz.repos.QuestionResultRepo;
import com.valtech.training.quiz.repos.QuizRepo;

public class QuestionResultVO {
	
	private long id;
	private long quizId ;
	private long questionId ;
	private String userAnswer ;
	private boolean result;
	
	public QuestionResultVO() {
		
	}

	public QuestionResultVO(long id, long quizId, long questionId, String userAnswer, boolean result) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.result = result;
	}

	
	public static QuestionResultVO from(QuestionResult qr) {
		return new QuestionResultVO(qr.getId(), qr.getQuiz().getId(), qr.getQuestion(), qr.getUserAnswer(), qr.isResult());
	}
	
	public QuestionResult to(Quiz q) {
		QuestionResult qr = new QuestionResult(questionId, userAnswer, result);
		qr.setQuiz(q);
		
		return qr;
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

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
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
