package io.egen.movieFlix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieFlix.entity.Movie;
import io.egen.movieFlix.exception.MovieAlreadyExistsException;
import io.egen.movieFlix.exception.MovieNotFoundException;
import io.egen.movieFlix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	CastService castService;
	
	@Autowired
	IMDBService imdbService;

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(String movieId) {
		Movie existingMovie = movieRepository.findById(movieId);
		if(existingMovie == null){
			throw new MovieNotFoundException("Movie with id "+movieId+" is not found");
		}
		return existingMovie;
	}

	@Override
	public Movie findByTitle(String movieTitle) {
		Movie existingMovie = movieRepository.findByTitle(movieTitle);
		if(existingMovie == null){
			throw new MovieNotFoundException("Movie with title "+movieTitle+" is not found");
		}
		return existingMovie;
	}

	@Override
	public List<Movie> findMoviesByType(String movieType) {
		List<Movie> movieList = movieRepository.findMoviesByType(movieType);
		
		return movieList;
	}

	@Override
	public List<Movie> findMoviesByYear(int year) {
		List<Movie> movieList = movieRepository.findMoviesByYear(year);
		
		return movieList;
	}

	@Override
	@Transactional
	public Movie createMovie(Movie movie) {
		Movie existingMovie = movieRepository.findByTitle(movie.getTitle());
		if (existingMovie != null) {
			throw new MovieAlreadyExistsException("Movie with title " + movie.getTitle()+" already exists");
		}
		//castService.createCast(movie.getMoviecast());
		imdbService.createIMDBRating(movie.getImdbRating());
		return movieRepository.createMovie(movie);
	}

	@Override
	@Transactional
	public Movie updateMovie(String movieId, Movie movie) {
		Movie existingMovie = movieRepository.findById(movieId);
		if (existingMovie == null) {
			throw new MovieNotFoundException("Movie with id " + movieId + " not found");
		}
		return movieRepository.updateMovie(movie);
	}

	@Override
	@Transactional
	public void deleteMovie(String movieId) {
		Movie existingMovie = movieRepository.findById(movieId);
		if (existingMovie == null) {
			throw new MovieNotFoundException("Movie with id:" + movieId + " not found");
		}
		movieRepository.deleteMovie(existingMovie);
	}
}
