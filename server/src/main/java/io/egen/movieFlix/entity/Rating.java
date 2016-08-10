package io.egen.movieFlix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Rating.findByMovie", query = "SELECT r FROM Rating r ORDER BY r.userRating DESC")})
public class Rating {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String ratingId;
	
	private double userRating;
	private String userReview;
	
	@OneToOne
	private Movie movie;
	
	@OneToOne
	private User user;

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
