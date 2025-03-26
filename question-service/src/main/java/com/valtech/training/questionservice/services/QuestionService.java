package com.valtech.training.questionservice.services;

import java.util.List;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.vos.QuestionVO;


public interface QuestionService {


	List<QuestionVO> getAllQuestion();

	QuestionVO getQuestion(long id);

	void deleteQuestion(Question question);

	QuestionVO saveandUpdateQuestion(QuestionVO question);

	List<QuestionVO> findRandomQuestionsByTopic(String topic);

}
