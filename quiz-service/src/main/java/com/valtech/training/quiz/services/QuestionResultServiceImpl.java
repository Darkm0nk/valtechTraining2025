package com.valtech.training.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.quiz.entities.QuestionResult;
import com.valtech.training.quiz.repos.QuestionResultRepo;
import com.valtech.training.quiz.repos.QuizRepo;
import com.valtech.training.quiz.vos.QuestionResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionResultServiceImpl implements QuestionResultService {

	@Autowired
	private QuestionResultRepo questionResultRepo;
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	
	
	@Override
	public QuestionResultVO createQuestionResult(QuestionResultVO questionResultVO) {
		if(questionResultVO.getUserAnswer().equals(questionClient.getAnswerById(questionResultVO.getQuestionId()).correctopt())) {
			questionResultVO.setResult(true);
		}
		else {
			questionResultVO.setResult(false);
		} 
		return QuestionResultVO.from(questionResultRepo.save(questionResultVO.to(quizRepo.getReferenceById(questionResultVO.getQuizId()))));
	}
	
	
	@Override
	public List<QuestionResultVO> getAllQuestionResultByQuizId(long id){
		return questionResultRepo.findAllByQuizId(id).stream().map(qr->QuestionResultVO.from(qr)).collect(Collectors.toList());
	}
	
	
}
