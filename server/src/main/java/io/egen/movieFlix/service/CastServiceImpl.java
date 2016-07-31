package io.egen.movieFlix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieFlix.entity.Cast;
import io.egen.movieFlix.repository.CastRepository;

@Service
public class CastServiceImpl implements CastService {
	
	@Autowired
	CastRepository castRepository;
	
	@Transactional
	@Override
	public void createCast(List<Cast> movieCast) {
		castRepository.createCast(movieCast);
	}

}
