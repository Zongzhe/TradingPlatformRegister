package com.fdm.test.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.LoginException;
import com.fdm.validators.LoginValidator;

import static org.mockito.Mockito.*;

/*
 * LoginValidatorTest class: to test whether the validator can validate user successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 02/12/2014
 */

public class LoginValidatorTest {

	private User			mockUser;
	private Storage			mockStorage;
	private LoginValidator	logVali;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(Storage.class);
		logVali = new LoginValidator();
		logVali.setStorage(mockStorage);
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then validate should throw a LoginException
	@Test (expected = LoginException.class)
	public void testRegistrrationExceptionWhenInvalidUserIsPassedInValidator() throws LoginException {
		when(mockUser.getUserName()).thenReturn("");
		when(mockStorage.get("username")).thenReturn(mockUser);
		logVali.Loginvalidate(mockUser);
	}
}
