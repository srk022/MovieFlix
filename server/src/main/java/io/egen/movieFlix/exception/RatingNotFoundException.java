package io.egen.movieFlix.exception;

public class RatingNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 8699605351712324429L;

	public RatingNotFoundException(String message) {
		super(message);
	}

	public RatingNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
