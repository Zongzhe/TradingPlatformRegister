package com.fdm.test.actions;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.actions.Login;
import com.fdm.model.MapUserStorageSingleton;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.LoginException;

import static org.mockito.Mockito.*;

/*
 * logistratorTest class: ensure that the loginUser(User) method calls the Storage’s add(user) method
 * 
 * @Author: Zongzhe Chen Create Time: 02/12/2014
 */

public class LoginTest {

	private Login				login;
	private User				mockUser;
	private Storage				mockStorage;
	private Map<String, User>	mockMap;

	// Before: create and initialise the test
	@SuppressWarnings ("unchecked")
	@Before
	public void setup() {

		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(MapUserStorageSingleton.class);
		login = new Login();
		mockMap = Mockito.mock(Map.class);
		((MapUserStorageSingleton) mockStorage).setMap(mockMap);
	}

	// Test: test that the setEnable method in User class is called when the program calls the login method
	@Test
	public void testSetEnableIsCalledInUserWhenTheLoginIsCalled() {

		login.loginUser(mockUser);
		verify(mockUser, times(1)).setEnable(true);
	}

	// Test: test that the setRole method in User class is called when the program calls the login method
	@Test
	public void testSetRoleIsCalledInUserWhenTheLoginIsCalled() {

		login.loginUser(mockUser);
		verify(mockUser, times(1)).setRole(1);
	}

	// Test: test that the role is set to 2 when the program calls the getUserRole method
	@Test
	public void testRoleIsSetToOneInUserWhenTheGetUserRoleIsCalled() {

		when(mockUser.getRole()).thenReturn(2);
		int role = login.getUserRole(mockUser);
		assertEquals(2, role);
	}

	// Test: test that the enable is set to flase when the program calls the getEnable method
	@Test
	public void testenableIsSetToFalseInUserWhenTheGetUserEnableIsCalled() {

		when(mockUser.isEnable()).thenReturn(false);
		boolean enable = login.getUserAbility(mockUser);
		assertEquals(false, enable);
	}
}
