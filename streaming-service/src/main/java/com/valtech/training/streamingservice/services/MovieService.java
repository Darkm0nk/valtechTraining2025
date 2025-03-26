package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.MovieVO;

public interface MovieService {

	MovieVO createMovie(MovieVO movieVO);

	MovieVO getMovie(long id);

	void deleteMovie(long id);

	List<MovieVO> getAllMovies();

	List<MovieVO> getAllByGenre(String genre);

	List<MovieVO> getAllByGenreAndLanguage(String genre, String language);

}