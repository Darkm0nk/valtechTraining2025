package com.valtech.training.quiz.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz.services.QuestionClient;
import com.valtech.training.quiz.services.QuizService;
import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizVO;



@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

	@Autowired
	private QuestionClient questionClient;
	
	@Autowired
	private QuizService quizService;

	@GetMapping("/{topic}")
	public List<QuestionVO> getQuestionsForQuiz(@PathVariable String topic){
		List<QuestionVO> vos = questionClient.getAllQuestions(topic);
		System.out.println("Returning VOS....");
		return vos.stream().collect(Collectors.toList());
	}
	
	@PostMapping("/")
	public List<QuestionVO> createQuiz(@RequestBody QuizVO quizVO) {
		quizService.createQuiz(quizVO);
		
		return getQuestionsForQuiz(quizVO.topic());
	}
	
	
 

}
