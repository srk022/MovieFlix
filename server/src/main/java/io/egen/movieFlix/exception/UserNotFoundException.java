package io.egen.movieFlix.exception;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -6444324583290574403L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
