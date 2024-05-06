package com.test.testAssigment.core.utilities.mappers.exceptions;

public class AgeLessThanEighteenException extends Exception {
	public AgeLessThanEighteenException() {
	};

	public AgeLessThanEighteenException(String message) {
		super(message);
	}

	public AgeLessThanEighteenException(Throwable cause) {
		super(cause);
		
	}
	
	public AgeLessThanEighteenException(String message, Throwable cause) {
		super(message, cause);
	}

}
