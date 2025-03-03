package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.BookRepo;
import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;
import com.valtech.training.first.services.QuestionService;

@SpringBootTest
@Transactional(propagation = Propagation.REQUIRED)
class FirstApplicationTests {
	
	@Autowired
	private Arithmetic arithmetic;
	
	@Autowired
	private SimpleInterest simpleInterest;
	
	@Autowired
	private QuestionService questionService; 
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublisherService publisherService;
	@Test
	void testArithmetic() {
		assertEquals(10, arithmetic.add(4, 6));
//		assertEquals(200, simpleInterest(2,500,100));
	}
	@Test
	@Rollback()
	void questionService() {
		initData();
		assertEquals(6,questionService.countByTopic("Java"));
		assertEquals(2,questionService.countByTopicAndQuestionTextContaining("Java","Exception"));
		assertEquals(3,questionService.countByTopicAndQuestionTextContainingIgnoreCase("Java","interface"));
		assertEquals(5, questionService.findAllByTopic("GK", 0, 5).size());
		assertEquals(1, questionService.findAllByTopic("GK", 1, 5).size());
	}
	
	void initData() {
		long count = questionService.count();
		if(count != 0) return ;
		Question q = questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		questionService.saveQuestion(new Question("What is the color of sky?","Red","Blue","Green","White","Blue","GK"));
		
		questionService.saveQuestion(new Question("What is the Super Clsss of Exception?","Object","Exception","Throwable","Error","Throwable","Java"));
		questionService.saveQuestion(new Question("Which class is used to Create Dynamic Strings?","String","DynamicString","Builder","StringBuilder","StringBuilder","Java"));
		questionService.saveQuestion(new Question("How many methods are there in Marker Interface?","None","One","Two","Three","None","Java"));
		questionService.saveQuestion(new Question("How many methods are there in Functional Interface?","None","One","Two","Three","One","Java"));
		questionService.saveQuestion(new Question("Can an Interface have private methods?","Yes","No","Maybe ","No methods can be there in interface","Yes","Java"));
		questionService.saveQuestion(new Question("Which subclass of Exception is not checked by compiler?","Runtime","NullPoint","Two","Three","Runtime","Java"));
//		assertTrue(q.getId()>0);
//		assertEquals(count+1, questionService.count());
//		System.err.println(questionService.getClass().getName());
	}

	@Test
	void bookService() {
		assertEquals(19, bookService.getAllBooks().size());
		assertEquals(18, authorService.getAllAuthors().size());
		assertEquals(12, publisherService.getAllPublishers().size());
		
		assertEquals(6, bookService.getBooksByYearBetween(2000,2006).size());
		assertNotEquals(3, bookService.getBooksByPriceGreaterThan(100).size());
		assertEquals(1, bookService.getAllByAuthorsId(4).size());
		System.out.print(bookService.getAllByAuthorsId(4));
	}
}
