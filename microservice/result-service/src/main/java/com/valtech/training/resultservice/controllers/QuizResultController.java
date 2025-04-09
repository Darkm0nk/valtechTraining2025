package com.valtech.training.resultservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.resultservice.services.QuizResultService;
import com.valtech.training.resultservice.vos.QuizResultVO;



@RestController
@RequestMapping("/api/v1/quizresult")
public class QuizResultController {

	@Autowired
	private QuizResultService quizResultService;
	
	@PostMapping("/")
	public QuizResultVO createQuizResult(@RequestBody QuizResultVO  quizResultVO) {
		return  quizResultService.createQuizResult(quizResultVO);
	}
	
}
