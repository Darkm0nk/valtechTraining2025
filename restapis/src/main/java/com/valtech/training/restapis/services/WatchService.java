package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.WatchVO;

public interface WatchService {



	WatchVO getWatch(long id);

	WatchVO updateWatch(WatchVO watch, long id);

	WatchVO createWatch(WatchVO watch);

	List<WatchVO> getWatches();

	List<WatchVO> getWatchesByBrand(String brand);


}