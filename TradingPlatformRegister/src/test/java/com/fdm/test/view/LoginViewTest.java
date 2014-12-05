package com.fdm.test.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.model.User;
import com.fdm.view.LoginView;

import static org.mockito.Mockito.*;

/*
 * LoginViewTest class: to test whether the logistration view can display user successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class LoginViewTest {

	private LoginView logView;
	private Scanner scanner;
	private User user;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		logView = new LoginView();
		String details = "username\npassword\nfirstname\nlastname";
		scanner = new Scanner(new ByteArrayInputStream(details.getBytes()));
		logView.setScanner(scanner);
		user = logView.getInput();
	}

	// Test: If the details in input, the program can get username from
	// class user
	@Test
	public void testUserNameGetFromUserIfDetailsPassedInFromScanner() {
		assertEquals("username", user.getUserName());
	}

	// Test: If the details in input, the program can get password from
	// class user
	@Test
	public void testPassWordGetFromUserIfDetailsPassedInFromScanner() {
		assertEquals("password", user.getPassWord());
	}

}
