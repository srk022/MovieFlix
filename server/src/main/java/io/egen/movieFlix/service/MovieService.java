package io.egen.movieFlix.service;

import java.util.List;

import io.egen.movieFlix.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findById(String movieId);

	public Movie findByTitle(String movieTitle);

	public List<Movie> findMoviesByType(String movieType);

	public List<Movie> findMoviesByYear(int year);

	//public List<Movie> sortMoviesByYear(int year);

	public Movie createMovie(Movie movie);

	public Movie updateMovie(String movieId, Movie movie);

	public void deleteMovie(String movieId);
}
