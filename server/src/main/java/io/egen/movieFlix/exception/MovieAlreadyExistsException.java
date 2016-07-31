package io.egen.movieFlix.exception;

public class MovieAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 6636173661437354564L;

	public MovieAlreadyExistsException(String message) {
		super(message);
	}

	public MovieAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
