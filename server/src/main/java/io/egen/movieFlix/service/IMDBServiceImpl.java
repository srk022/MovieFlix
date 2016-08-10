package io.egen.movieFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieFlix.entity.IMDB;
import io.egen.movieFlix.repository.IMDBRepository;

@Service
public class IMDBServiceImpl implements IMDBService {
	
	@Autowired
	IMDBRepository imdbRepository;
	
	@Transactional
	@Override
	public void createIMDBRating(IMDB imdb) {
		imdbRepository.createIMDBRating(imdb);
	}

}
