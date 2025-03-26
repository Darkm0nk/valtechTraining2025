package com.valtech.training.resultservice.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.valtech.training.resultservice.vos.QuizResultVO;

public interface QuizResultService {

	QuizResultVO createQuizResult(QuizResultVO quizResultVO);

	QuizResultVO getQuizResult(long id);

}