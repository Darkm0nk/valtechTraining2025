package com.valtech.training.resultservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.resultservice.entities.QuizResult;

@Repository
public interface QuizResultRepo extends JpaRepository<QuizResult, Long>{

}
