package com.valtech.training.streamingservice.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
	@Override
	public WebSeriesVO createSeries(WebSeriesVO webSeriesVO) {
		return WebSeriesVO.from(webSeriesRepo.save(webSeriesVO.to()));
	}
	
	@Override
	public WebSeriesVO getSeries(long id) {
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	@Override
	public void deleteSeries(long id) {
		webSeriesRepo.deleteById(id);;
	}
	
	@Override
	public List<WebSeriesVO>  getAllSerieses( ) {
		return WebSeriesVO.from(webSeriesRepo.findAll());
	}
	
	@Override
	public List<WebSeriesVO> getAllSeriesesByEpisodeCount(int episodeCount){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeCount(episodeCount));
	}
	
	@Override
	public List<WebSeriesVO> getAllSeriesesByEpisodeDuration(long episodeDuration){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeDuration(episodeDuration));
	}
}
