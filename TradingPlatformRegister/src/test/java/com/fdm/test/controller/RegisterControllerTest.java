package com.fdm.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.actions.Register;
import com.fdm.controller.RegistrationController;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.RegistrationException;
import com.fdm.validators.RegistrationValidator;
import com.fdm.view.RegistrationView;

import static org.mockito.Mockito.*;

/*
 * RegisterControllerTest class: to test whether the register controller can connect the view, register, and validator successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 01/12/2014
 */
public class RegisterControllerTest {

	private Register mockRegister;
	private RegistrationController regCon;
	private RegistrationValidator mockRegVali;
	private RegistrationView mockRegView;
	private User mockUser;
	private Storage mockStorage;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		mockRegister = Mockito.mock(Register.class);
		mockRegView = Mockito.mock(RegistrationView.class);
		mockRegVali = Mockito.mock(RegistrationValidator.class);
		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(Storage.class);
		regCon = new RegistrationController(mockRegView, mockRegVali,
				mockRegister);
		when(mockRegView.getInput()).thenReturn(mockUser);
		when(mockUser.getUserName()).thenReturn("username");
		when(mockStorage.get("username")).thenReturn(mockUser);
	}

	// Test: Test that the Controller Handle Controller’s handle method calls
	// the getInput() method from the view object.
	@Test
	public void testControllerHandleMethodCallsRegisterViewInput()
			throws RegistrationException {

		regCon.handle();
		verify(mockRegView, times(1)).getInput();
	}

	// Test: Test that the Controller Handle method that the user returned from
	// the getInput Method is passed to the RegistrationValidator’s
	// validate(User) method
	@Test
	public void testControllerHandleMethodPassesTheStringUserFromGetInputMethodToValidate()
			throws RegistrationException {

		regCon.handle();
		verify(mockRegVali, times(1)).validate(mockUser);
	}

	// Test: Test that if the username is valid (i.e. the user doesn’t exist in
	// storage) then the registerUser(User) method should be called
	@Test
	public void testControllerHandleMethodPassesTheStringUserFromGetInputMethodToValidateAndRegisterIfUserNameIsValid()
			throws RegistrationException {

		regCon.handle();
		verify(mockRegister, times(1)).registerUser(mockUser);
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then
	// validate should throw a RegistrationException
	@Test(expected = RegistrationException.class)
	public void testRegistrrationExceptionWhenInvalidUserIsPassedIn()
			throws RegistrationException {

		doThrow(new RegistrationException("User invalid!")).when(mockRegVali)
				.validate(mockUser);
		regCon.handle();
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then
	// the registerUser(User) method should not get called
	@Test(expected = RegistrationException.class)
	public void testRegisterNotCalledWhenInvalidUserIsPassedIn()
			throws RegistrationException {

		doThrow(new RegistrationException("User invalid!")).when(mockRegVali)
				.validate(mockUser);
		regCon.handle();
		verify(mockRegister, times(0)).registerUser(mockUser);
	}

}
