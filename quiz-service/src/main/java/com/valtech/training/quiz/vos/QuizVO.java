package com.valtech.training.quiz.vos;

import com.valtech.training.quiz.entities.Quiz;

public record QuizVO (long id, String username, String topic){

	public static QuizVO from(Quiz quiz) {
		return new QuizVO(quiz.getId(), quiz.getUser(), quiz.getTopic());
	}
	
	public Quiz to() {
		return new Quiz(id, username, topic);
	}
	
}
