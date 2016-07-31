package io.egen.movieFlix.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.movieFlix.entity.Rating;

@Repository
public class UserRatingRepositoryImpl implements UserRatingRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Rating> findRatingsByMovieId(String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByMovie", Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating createRating(Rating movieRating) {
		em.persist(movieRating);
		return movieRating;
	}

	@Override
	public Rating updateRating(Rating movieRating) {
		return em.merge(movieRating);
	}

	@Override
	public void deleteRating(Rating movieRating) {
		em.remove(movieRating);
	}

	@Override
	public Rating findRatingsById(String ratingId) {
		return em.find(Rating.class, ratingId);
	}

}
