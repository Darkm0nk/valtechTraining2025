package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO createSeries(WebSeriesVO webSeriesVO);

	WebSeriesVO getSeries(long id);

	void deleteSeries(long id);

	List<WebSeriesVO> getAllSerieses();

	List<WebSeriesVO> getAllSeriesesByEpisodeCount(int episodeCount);

	List<WebSeriesVO> getAllSeriesesByEpisodeDuration(long episodeDuration);

}