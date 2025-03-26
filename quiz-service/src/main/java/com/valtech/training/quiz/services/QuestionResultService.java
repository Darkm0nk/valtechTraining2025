package com.valtech.training.quiz.services;

import java.util.List;

import com.valtech.training.quiz.vos.QuestionResultVO;

public interface QuestionResultService {

	QuestionResultVO createQuestionResult(QuestionResultVO questionResultVO);

	List<QuestionResultVO> getAllQuestionResultByQuizId(long id);

}