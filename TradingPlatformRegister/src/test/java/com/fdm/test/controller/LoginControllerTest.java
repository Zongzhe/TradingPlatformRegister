package com.fdm.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.actions.Login;
import com.fdm.controller.LoginController;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.LoginException;
import com.fdm.validators.LoginValidator;
import com.fdm.view.LoginView;

import static org.mockito.Mockito.*;

/*
 * ControllerTest class: to test whether the controller can connect the view, logister, and validator successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 01/12/2014
 */
public class LoginControllerTest {

	private Login				mockLogin;
	private LoginController	logCon;
	private LoginValidator	mockRegVali;
	private LoginView		mockRegView;
	private User					mockUser;
	private Storage					mockStorage;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		mockLogin = Mockito.mock(Login.class);
		mockRegView = Mockito.mock(LoginView.class);
		mockRegVali = Mockito.mock(LoginValidator.class);
		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(Storage.class);
		logCon = new LoginController(mockRegView, mockRegVali, mockLogin);
		when(mockRegView.getInput()).thenReturn(mockUser);
		when(mockUser.getUserName()).thenReturn("username");
		when(mockStorage.get("username")).thenReturn(mockUser);
	}

	// Test: Test that the Controller Handle Controller’s handle method calls
	// the getInput() method from the view object.
	@Test
	public void testControllerHandleMethodCallsLoginViewInput() throws LoginException {

		logCon.handle();
		verify(mockRegView, times(1)).getInput();
	}

	// Test: Test that the Controller Handle method that the user returned from
	// the getInput Method is passed to the LoginValidator’s
	// validate(User) method
	@Test
	public void testControllerHandleMethodPassesTheStringUserFromGetInputMethodToValidate()
			throws LoginException {

		logCon.handle();
		verify(mockRegVali, times(1)).Loginvalidate(mockUser);
	}

	// Test: Test that if the username is valid (i.e. the user doesn’t exist in storage) then the logisterUser(User) method should be called
	@Test
	public void testControllerHandleMethodPassesTheStringUserFromGetInputMethodToValidateAndLoginIfUserNameIsValid()
			throws LoginException {

		logCon.handle();
		verify(mockLogin, times(1)).loginUser(mockUser);
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then validate should throw a LoginException
	@Test (expected = LoginException.class)
	public void testRegistrrationExceptionWhenInvalidUserIsPassedIn() throws LoginException {

		doThrow(new LoginException("User invalid!")).when(mockRegVali).Loginvalidate(mockUser);
		logCon.handle();
	}

	// Test: If the username is invalid (i.e. the user exists in storage) then the logisterUser(User) method should not get called
	@Test (expected = LoginException.class)
	public void testLoginNotCalledWhenInvalidUserIsPassedIn() throws LoginException {

		doThrow(new LoginException("User invalid!")).when(mockRegVali).Loginvalidate(mockUser);
		logCon.handle();
		verify(mockLogin, times(0)).loginUser(mockUser);
	}

}
