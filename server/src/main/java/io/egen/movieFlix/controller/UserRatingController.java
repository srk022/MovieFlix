package io.egen.movieFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieFlix.entity.Rating;
import io.egen.movieFlix.service.UserRatingService;

@RestController
@RequestMapping(path = "ratings")
public class UserRatingController {
	
	@Autowired
	UserRatingService userRatingService;
	
	@RequestMapping(method = RequestMethod.GET, path = "movieId/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findRatingsByMovie(@PathVariable("movieId") String movieId){
		return userRatingService.findRatingsByMovieId(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "ratingId/{ratingId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findRatingsById(@PathVariable("ratingId") String ratingId){
		return userRatingService.findRatingsById(ratingId);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating createRating(@RequestBody Rating movieRating){
		return userRatingService.createRating(movieRating);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "{ratingId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating updateRating(@PathVariable("ratingId") String ratingId, @RequestBody Rating movieRating){
		return userRatingService.updateRating(ratingId, movieRating);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{ratingId}")
	public void deleteRating(@PathVariable("ratingId") String ratingId){
		userRatingService.deleteRating(ratingId);
	}
}
