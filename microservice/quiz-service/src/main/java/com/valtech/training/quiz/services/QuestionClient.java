 package com.valtech.training.quiz.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.quiz.vos.QuestionVO;

@Component
public class QuestionClient {

	public List<QuestionVO> getAllQuestions(String topic){
		RestTemplate restTemplate = new RestTemplate();
		String url  = "http://localhost:9050/api/v1/questions/topic/"+topic;
		List<QuestionVO> questions = Arrays.asList(restTemplate.getForObject(url, QuestionVO[].class)) ;
		System.out.println("question in QuestionClient :: "+ questions);
		
		return questions;
		
	}
	
	public QuestionVO  getAnswerById(long id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9050/api/v1/questions/"+id;
		QuestionVO question = restTemplate.getForObject(url, QuestionVO.class);
		return question;
	}
}
