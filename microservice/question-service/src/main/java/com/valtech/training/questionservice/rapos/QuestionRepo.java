package com.valtech.training.questionservice.rapos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valtech.training.questionservice.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Long>{

	@Query(value = "SELECT * FROM Question WHERE topic = :topic ORDER BY RANDOM() LIMIT 5 ", nativeQuery = true)
	List<Question> findRandomQuestionsByTopic(@Param("topic") String topic);

	String findCorrectoptById(long id);

}
