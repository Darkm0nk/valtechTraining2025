package com.valtech.training.resultservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.valtech.training.resultservice.entities.QuizResult;
import com.valtech.training.resultservice.repos.QuizResultRepo;
import com.valtech.training.resultservice.vos.QuestionResultVO;
import com.valtech.training.resultservice.vos.QuizResultVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuizResultServiceImpl implements QuizResultService {
	
	@Autowired
	private QuizResultRepo quizResultRepo;
	
	@Autowired
	private QuizClient quizClient;
	
	@Override
	public QuizResultVO createQuizResult(QuizResultVO quizResultVO) {
		QuizResult qr = quizResultVO.to();
		int score = 0;
		List<QuestionResultVO> results = quizClient.getAllQuestionResultByQuizId(quizResultVO.quizId());
		for (QuestionResultVO result : results) {
			if(result.result()==true) {
				System.out.println("++++++++++++++++++++++++++");
				score++;
			}
		}
		System.out.println("score::"+score);
		qr.setScore(score);
		qr.setPercentage(((long)score/results.size())*100);
		return QuizResultVO.from(quizResultRepo.save(qr));
		
	}
	
	@Override
	public QuizResultVO getQuizResult(@RequestBody long id) {
		
		return null;
	}
}
