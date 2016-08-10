package io.egen.movieFlix.service;

import java.util.List;

import io.egen.movieFlix.entity.Rating;

public interface UserRatingService {
	
	public List<Rating> findRatingsByMovieId(String movieId);
	public Rating findRatingsById(String ratingId);
	public Rating createRating(Rating movieRating);
	public Rating updateRating(String ratingId, Rating movieRating);
	public void deleteRating(String ratingId);
}
