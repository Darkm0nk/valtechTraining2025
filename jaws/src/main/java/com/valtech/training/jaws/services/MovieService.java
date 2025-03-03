package com.valtech.training.jaws.services;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.jaws.Movie;

public interface MovieService {

	Movie createMovie(Movie m);

	Movie getMovie(long id);

	List<Movie> getAllMovies();

}