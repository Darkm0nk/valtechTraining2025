package com.valtech.training.questionservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.questionservice.entities.Question;
import com.valtech.training.questionservice.rapos.QuestionRepo;
import com.valtech.training.questionservice.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveandUpdateQuestion(QuestionVO question) {
		return QuestionVO.from(questionRepo.save(question.to())) ;
	}
	
	@Override
	public void deleteQuestion(Question question) {
		questionRepo.delete(question);
	}
	
	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id)) ;
	}
	
	@Override
	public List<QuestionVO> getAllQuestion(){
		return questionRepo.findAll().stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}  
	

	@Override
	public List<QuestionVO> findRandomQuestionsByTopic(String topic){
		return questionRepo.findRandomQuestionsByTopic(topic).stream().map(q->QuestionVO.from(q)).collect(Collectors.toList());
	}



	
}
