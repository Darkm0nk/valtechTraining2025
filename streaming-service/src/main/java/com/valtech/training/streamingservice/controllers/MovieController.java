package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.vos.MovieVO;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public List<MovieVO> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public MovieVO getMovieById(@PathVariable("id") long id) {
		return movieService.getMovie(id);
	}
	
	@PostMapping("/")
	public MovieVO createMovie(@RequestBody MovieVO movieVO) {
		return movieService.createMovie(movieVO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovieById(@PathVariable("id") long id) {
		movieService.deleteMovie(id);
	}
	
	@GetMapping("/genre/{genre}")
	public List<MovieVO> getAllMoviesByGenre(@PathVariable("genre") String genre){
		return movieService.getAllByGenre(genre);
	}
	
}
