package com.example.pbapp.exception;

@SuppressWarnings("serial")
public class BlockUserException extends Exception {
	/**
	 * Creating BlockUserException object without error message
	 */
	public BlockUserException() {
		super();
	}

	/**
	 * Creating BlockUserException object with error Message
	 * @param errMsg that will be passed when thrown BlockUserException
	 */
	public BlockUserException(String errMsg) {
		super(errMsg);
	}
}
