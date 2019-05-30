package com.example.pbapp.exception;


public class UserAlreadyExistException extends Exception{

	/**
	 * Creating BlockUserException object without error message
	 */
	public UserAlreadyExistException() {
		super();
	}

	/**
	 * Creating BlockUserException object with error Message
	 * @param errMsg that will be passed when thrown BlockUserException
	 */
	public UserAlreadyExistException(String errMsg) {
		super(errMsg);
	}
}
