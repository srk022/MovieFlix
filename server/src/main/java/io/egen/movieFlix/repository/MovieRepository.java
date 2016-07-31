package io.egen.movieFlix.repository;

import java.util.List;

import io.egen.movieFlix.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();

	public Movie findById(String movieId);

	public Movie findByTitle(String movieTitle);

	public List<Movie> findMoviesByType(String movieType);

	public List<Movie> findMoviesByYear(int year);

	public Movie createMovie(Movie movie);

	public Movie updateMovie(Movie movie);

	public void deleteMovie(Movie movie);
}
