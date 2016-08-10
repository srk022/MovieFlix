package io.egen.movieFlix.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle"),
		@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear") })
public class Movie {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String movieId;

	@Column(unique = true)
	private String title;

	private String rated;
	private int year;
	private String released;
	private String runtime;
	private String plot;
	private String language;
	private String country;
	private String poster;
	private String type;
	private int metascore;
	private String awards;
	private String genre;

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Cast> moviecast;

	@OneToOne
	private IMDB imdbRating;

	public List<Cast> getMoviecast() {
		return moviecast;
	}

	public void setMoviecast(List<Cast> moviecast) {
		this.moviecast = moviecast;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public IMDB getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(IMDB imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenreList(String genre) {
		this.genre = genre;
	}
}
