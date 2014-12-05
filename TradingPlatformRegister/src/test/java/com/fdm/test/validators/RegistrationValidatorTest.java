package com.fdm.test.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.RegistrationException;
import com.fdm.validators.RegistrationValidator;

import static org.mockito.Mockito.*;

/*
 * RegistrationValidatorTest class: to test whether the validator can validate user successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 02/12/2014
 */

public class RegistrationValidatorTest {

	User mockUser;
	Storage mockStorage;
	RegistrationValidator regVali;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(Storage.class);
		regVali = new RegistrationValidator();
		regVali.setStorage(mockStorage);
		when(mockUser.getUserName()).thenReturn("username");
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then
	// validate should throw a RegistrationException
	@Test(expected = RegistrationException.class)
	public void testRegistrrationExceptionWhenInvalidUserIsPassedInValidator()
			throws RegistrationException {

		when(mockStorage.get("username")).thenReturn(mockUser);
		regVali.validate(mockUser);
	}

	// Test: No exception is thrown when the user does not exist in storage.
	@Test
	public void testNoRegistrrationExceptionWhenValidUserIsPassedInValidator()
			throws RegistrationException {

		when(mockStorage.get("username")).thenReturn(null);
		regVali.validate(mockUser);
	}

}
