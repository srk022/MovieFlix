package io.egen.movieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieFlix.entity.Movie;
import io.egen.movieFlix.service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return movieService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "id/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findById(@PathVariable("id") String movieId) {
		return movieService.findById(movieId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "title/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("title") String movieTitle) {
		return movieService.findByTitle(movieTitle);
	}

	@RequestMapping(method = RequestMethod.GET, path = "type/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findMoviesByType(@PathVariable("type") String type) {
		return movieService.findMoviesByType(type);
	}

	@RequestMapping(method = RequestMethod.GET, path = "year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findMoviesByYear(@PathVariable("year") int year) {
		return movieService.findMoviesByYear(year);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createMovie(@RequestBody Movie movie) {
		return movieService.createMovie(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie updateMovie(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {
		return movieService.updateMovie(movieId, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{movieId}")
	public void deleteMovie(@PathVariable("movieId") String movieId) {
		movieService.deleteMovie(movieId);
	}
}
