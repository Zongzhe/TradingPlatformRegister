package com.fdm.validators;

/*
 * RegistrationException: throws the exception. The error message is specified in validator.
 * 
 * @Author: Zongzhe Chen Create Time: 02/12/2014
 */

public class LoginException extends Exception{
	
	public LoginException(String message) {
		super(message);
	}
}
