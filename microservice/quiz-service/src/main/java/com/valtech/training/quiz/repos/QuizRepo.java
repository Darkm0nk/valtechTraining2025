package com.valtech.training.quiz.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.quiz.entities.Quiz;


public interface QuizRepo extends JpaRepository<Quiz, Long>{

	

}
