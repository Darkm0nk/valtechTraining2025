package com.valtech.training.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.quiz.entities.Quiz;
import com.valtech.training.quiz.repos.QuizRepo;
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public QuizVO createQuiz(QuizVO quizVO) {
		
		return QuizVO.from(quizRepo.save(quizVO.to())) ;
	}



}
