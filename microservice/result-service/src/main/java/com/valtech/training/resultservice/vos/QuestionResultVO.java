package com.valtech.training.resultservice.vos;

public record QuestionResultVO (long id, long quizId , long questionId , String userAnswer, boolean result){

}
