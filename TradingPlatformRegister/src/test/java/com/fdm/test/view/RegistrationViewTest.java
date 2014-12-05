package com.fdm.test.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.model.User;
import com.fdm.view.RegistrationView;

import static org.mockito.Mockito.*;

/*
 * RegistrationViewTest class: to test whether the registration view can display user successfully.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class RegistrationViewTest {

	private RegistrationView regView;
	private Scanner scanner;
	private User user;

	// Before: create and initialise the controller class
	@Before
	public void setup() {

		regView = new RegistrationView();
		String details = "username\npassword\nfirstname\nlastname";
		scanner = new Scanner(new ByteArrayInputStream(details.getBytes()));
		regView.setScanner(scanner);
		user = regView.getInput();
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

	// Test: If the details in input, the program can get firstname from
	// class user
	@Test
	public void testFirstNameGetFromUserIfDetailsPassedInFromScanner() {
		assertEquals("firstname", user.getFirstName());
	}

	// Test: If the details in input, the program can get lastname from
	// class user
	@Test
	public void testLastNameGetFromUserIfDetailsPassedInFromScanner() {
		assertEquals("lastname", user.getLastName());
	}
}
