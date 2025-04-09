package com.valtech.training.quizservice;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.quiz.vos.QuestionVO;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class QuizServiceApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		
	}

	@Test
	void createQuestion() {
		System.out.println("=====================================");
		String url = "http://localhost:"+port+"/api/v1/questions/";
		List question = restTemplate.getForObject(url, List.class);
		if(question.size()==0) {
			System.out.println("creating question");
			QuestionVO q =  restTemplate.postForObject(url, new QuestionVO(0, "What is the color of sky?","Red","Blue","Green","White","Blue","GK") , QuestionVO.class);
			System.out.println(q.questionText());
		}
	}
	

}
