package io.egen.movieFlix.repository;

import java.util.List;

import io.egen.movieFlix.entity.Rating;

public interface UserRatingRepository {
	
	public List<Rating> findRatingsByMovieId(String movieId);
	public Rating findRatingsById(String ratingId);
	public Rating createRating(Rating movieRating);
	public Rating updateRating(Rating movieRating);
	public void deleteRating(Rating movieRating);
}
