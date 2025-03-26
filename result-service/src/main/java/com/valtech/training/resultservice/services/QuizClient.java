package com.valtech.training.resultservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.training.resultservice.vos.QuestionResultVO;



@Component
public class QuizClient {

	public List<QuestionResultVO> getAllQuestionResultByQuizId(long quizId){
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:9040/api/v1/questionresults/quiz/"+ quizId;
		List<QuestionResultVO> questionResult = Arrays.asList(restTemplate.getForObject(url, QuestionResultVO[].class));
		return questionResult;
	}
	
}
