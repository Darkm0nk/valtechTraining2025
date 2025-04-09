package com.valtech.training.questionservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.questionservice.services.QuestionService;
import com.valtech.training.questionservice.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/")
	public QuestionVO createQuestion(@RequestBody QuestionVO question) {
		return questionService.saveandUpdateQuestion(question); 
	}
	          
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable(name = "id") long id) {
		return questionService.getQuestion(id);
	}
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestion(){
		return questionService.getAllQuestion();
	}
	
	@GetMapping("/topic/{topic}")
	public List<QuestionVO> getQuestionByTopic(@PathVariable(name = "topic") String topic) {
		return questionService.findRandomQuestionsByTopic(topic);
	}
	
}
