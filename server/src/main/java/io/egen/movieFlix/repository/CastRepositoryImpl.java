package io.egen.movieFlix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.movieFlix.entity.Cast;

@Repository
public class CastRepositoryImpl implements CastRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void createCast(List<Cast> movieCast) {
		for(Cast cast: movieCast){
		em.persist(cast);
		}
	}

}
