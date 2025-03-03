package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.PublisherRepo;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherRepo publisherRepo;
	
	@Override
	public List<Publisher> getAllPublishers(){
		return publisherRepo.findAll();
	}
	
	
}
