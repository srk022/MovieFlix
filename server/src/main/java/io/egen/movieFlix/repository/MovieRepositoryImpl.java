package io.egen.movieFlix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieFlix.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findById(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByTitle(String movieTitle) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", movieTitle);
		List<Movie> movieList = query.getResultList();
		if (movieList != null && movieList.size() == 1) {
			return movieList.get(0);
		}
		return null;
	}

	@Override
	public List<Movie> findMoviesByType(String movieType) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", movieType);
		List<Movie> movieList = query.getResultList();
		if (movieList != null && movieList.size() > 0) {
			return movieList;
		}
		return null;
	}

	@Override
	public List<Movie> findMoviesByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		List<Movie> movieList = query.getResultList();
		if (movieList != null && movieList.size() > 0) {
			return movieList;
		}
		return null;
	}

	@Override
	public Movie createMovie(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void deleteMovie(Movie movie) {
		em.remove(movie);
	}

}
