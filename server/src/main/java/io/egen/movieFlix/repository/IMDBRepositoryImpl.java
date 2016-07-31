package io.egen.movieFlix.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.movieFlix.entity.IMDB;

@Repository
public class IMDBRepositoryImpl implements IMDBRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createIMDBRating(IMDB imdb) {
		em.persist(imdb);
	}

}
