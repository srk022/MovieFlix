package io.egen.movieFlix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieFlix.entity.Movie;
import io.egen.movieFlix.entity.Rating;
import io.egen.movieFlix.entity.User;
import io.egen.movieFlix.exception.MovieNotFoundException;
import io.egen.movieFlix.exception.RatingNotFoundException;
import io.egen.movieFlix.exception.UserNotFoundException;
import io.egen.movieFlix.repository.UserRatingRepository;

@Service
public class UserRatingServiceImpl implements UserRatingService {

	@Autowired
	UserRatingRepository userRatingRepository;

	@Autowired
	MovieService movieService;

	@Autowired
	UserService userService;

	@Override
	public List<Rating> findRatingsByMovieId(String movieId) {
		Movie movie = movieService.findById(movieId);
		if (movie == null) {
			throw new MovieNotFoundException("Movie with id " + movieId + " does not found");
		}
		return userRatingRepository.findRatingsByMovieId(movieId);
	}

	@Transactional
	@Override
	public Rating createRating(Rating movieRating) {
		String movieId = movieRating.getMovie().getMovieId();
		String userId = movieRating.getUser().getUserId();
		Movie movie = movieService.findById(movieId);
		User user = userService.findOne(userId);
		if (movie == null) {
			throw new MovieNotFoundException("Movie with id " + movieId + " does not found");
		}
		if (user == null) {
			throw new UserNotFoundException("User with id " + userId + " does not found");
		}
		movieRating.setMovie(movie);
		movieRating.setUser(user);
		return userRatingRepository.createRating(movieRating);
	}

	@Transactional
	@Override
	public Rating updateRating(String ratingId, Rating movieRating) {
		Rating existingRating = userRatingRepository.findRatingsById(ratingId);
		if (existingRating == null) {
			throw new RatingNotFoundException("Rating with id " + ratingId + " does not found");
		}
		String movieId = existingRating.getMovie().getMovieId();
		String userId = existingRating.getUser().getUserId();
		Movie movie = movieService.findById(movieId);
		User user = userService.findOne(userId);
		if (movie == null) {
			throw new MovieNotFoundException("Movie with id " + movieId + " does not found");
		}
		if (user == null) {
			throw new UserNotFoundException("User with id " + userId + " does not found");
		}
		movieRating.setMovie(movie);
		movieRating.setUser(user);
		return userRatingRepository.updateRating(movieRating);
	}

	@Transactional
	@Override
	public void deleteRating(String ratingId) {
		Rating existingRating = userRatingRepository.findRatingsById(ratingId);
		if (existingRating == null) {
			throw new RatingNotFoundException("Rating with id " + ratingId + " does not found");
		}
		userRatingRepository.deleteRating(existingRating);
	}

	@Override
	public Rating findRatingsById(String ratingId) {
		return userRatingRepository.findRatingsById(ratingId);
	}

}
