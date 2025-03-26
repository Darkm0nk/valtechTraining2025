package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;

@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO createMovie(MovieVO movieVO) {
		return MovieVO.from(movieRepo.save(movieVO.to())) ;
	}
	
	@Override
	public MovieVO getMovie(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	
	@Override
	public void deleteMovie(long id) {
		movieRepo.deleteById(id);
	}
	
	@Override
	public List<MovieVO> getAllMovies(){
		return MovieVO.from(movieRepo.findAll());
	}
	
	@Override
	public List<MovieVO> getAllByGenre(String genre){
		return MovieVO.from(movieRepo.findAllByGenre(genre));
	}
	
	@Override
	public List<MovieVO> getAllByGenreAndLanguage(String genre, String language){
		return MovieVO.from(movieRepo.findAllByGenreAndLanguage(genre, language));
	}
}
