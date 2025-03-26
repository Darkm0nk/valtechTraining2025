package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webSerieses")
public class WebSeriesController {
	
	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO createWebSeries(@RequestBody WebSeriesVO webSeriesVO) {
		return webSeriesService.createSeries(webSeriesVO);
	}
	
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebSeries() {
		return webSeriesService.getAllSerieses();
	}
	
	@GetMapping("/{id}")
	public WebSeriesVO getWebSeries(@PathVariable("id") long id) {
		return webSeriesService.getSeries(id);
	}
	
	@GetMapping("/episodes/{episodeCount}")
	public List<WebSeriesVO> getAllWebSeriesByEpisodeCount(int episodeCount) {
		return webSeriesService.getAllSeriesesByEpisodeCount(episodeCount);
	}
	
	@GetMapping("/duration/{episodeDuration}")
	public List<WebSeriesVO> getAllWebSeriesByEpisodeDuration(int episodeDuration) {
		return webSeriesService.getAllSeriesesByEpisodeDuration(episodeDuration);
	}
}
