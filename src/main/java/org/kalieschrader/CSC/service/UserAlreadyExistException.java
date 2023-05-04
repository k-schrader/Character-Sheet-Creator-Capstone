package org.kalieschrader.CSC.service;

//Custom exception class that throws an exception when a a user tries to create an account with details already in the DB
public final class UserAlreadyExistException extends RuntimeException {

	public UserAlreadyExistException() {
		super();
	}

	public UserAlreadyExistException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistException(final String message) {
		super(message);
	}

	public UserAlreadyExistException(final Throwable cause) {
		super(cause);
	}
}