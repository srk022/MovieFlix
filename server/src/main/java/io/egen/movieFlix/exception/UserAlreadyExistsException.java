package io.egen.movieFlix.exception;

public class UserAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -5250502180582204154L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

	public UserAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
