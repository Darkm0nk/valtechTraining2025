package com.valtech.training.questionservice.vos;

import com.valtech.training.questionservice.entities.Question;

public record QuestionVO( long id,  String questionText,  String opt1 , String opt2, String opt3,  String opt4,  String correctopt, String topic){
	
	public static QuestionVO from(Question question) {
		return new QuestionVO(question.getId(), question.getQuestionText() , question.getOpt1(), question.getOpt2(), question.getOpt3(), question.getOpt4(), question.getCorrectopt(), question.getTopic());
		
	}
	
	public Question to() {
		return new Question( questionText, opt1, opt2, opt3, opt4, correctopt, topic);
	}
}
