package com.valtech.training.quiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.quiz.entities.QuestionResult;

@Repository
public interface QuestionResultRepo extends JpaRepository<QuestionResult, Long>{

	List<QuestionResult> findAllByQuizId(long id);
	
}
