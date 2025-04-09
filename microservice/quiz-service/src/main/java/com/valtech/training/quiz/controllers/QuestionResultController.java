package com.valtech.training.quiz.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.quiz.entities.QuestionResult;
import com.valtech.training.quiz.services.QuestionResultService;
import com.valtech.training.quiz.vos.QuestionResultVO;

@RestController
@RequestMapping("/api/v1/questionresults")
public class QuestionResultController {
	
	@Autowired
	private QuestionResultService questionResultService;
	
	@PostMapping("/")
	public List<QuestionResultVO>  createQuestionResult(@RequestBody List<QuestionResultVO>  questionResultVOs) {
		List<QuestionResultVO> results = new ArrayList<QuestionResultVO>();
		for (QuestionResultVO questionResultVO : questionResultVOs) {
			results.add(questionResultService.createQuestionResult(questionResultVO) ) ;
		}
		return results;
	}
	
	@GetMapping("/quiz/{id}")
	public List<QuestionResultVO> getAllQuestionResultByQuizId(@PathVariable long id){
		return questionResultService.getAllQuestionResultByQuizId(id);
	}
}
