package com.valtech.training.jaws.webservices;

import java.util.List;

import javax.jws.WebService;

import com.valtech.training.jaws.Movie;
@WebService
public interface MovieServiceWS {

	Movie createMovie(Movie m);

	Movie getMovie(long id);

	List<Movie> getAllMovies();

}