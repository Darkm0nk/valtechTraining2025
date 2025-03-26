package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO (long id , String name , String genre , String language, long costPerView , long duration){

	public static MovieVO from(Movie movie) {
		return new MovieVO(movie.getId(), movie.getName(), movie.getGenre(), movie.getLanguage(), movie.getCostPerView(), movie.getDuration());
	}
	
	public Movie to() {
		return new Movie(name, genre, language, costPerView, duration);
	}
	
	public static List<MovieVO> from(List<Movie> movies){
		return movies.stream().map(m->MovieVO.from(m)).collect(Collectors.toList());
	}
}
