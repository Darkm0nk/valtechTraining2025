package com.valtech.training.resultservice.vos;

import com.valtech.training.resultservice.entities.QuizResult;

public record QuizResultVO(long id, long quizId,  int score , long percentage) {
	
	public static QuizResultVO from(QuizResult quizResult) {
		return new QuizResultVO(quizResult.getId(), quizResult.getQuizId(), quizResult.getScore(), quizResult.getPercentage());
	}
	
	public QuizResult to() {
		return new QuizResult(quizId, score, percentage);
	}
}
