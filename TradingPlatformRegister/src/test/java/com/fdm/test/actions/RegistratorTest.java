package com.fdm.test.actions;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.actions.Register;
import com.fdm.model.MapUserStorageSingleton;
import com.fdm.model.User;
import com.fdm.model.storage.Storage;
import com.fdm.validators.RegistrationException;
import com.fdm.validators.RegistrationValidator;

import static org.mockito.Mockito.*;

/*
 * RegistratorTest class: ensure that the registerUser(User) method calls the Storage’s add(user) method
 * 
 * @Author: Zongzhe Chen Create Time: 02/12/2014
 */

public class RegistratorTest {

	private Register register;
	private User mockUser;
	private Storage mockStorage;
	private Map<String, User> mockMap;

	// Before: create and initialise the test
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {

		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(MapUserStorageSingleton.class);
		register = new Register();
		mockMap = Mockito.mock(Map.class);
		((MapUserStorageSingleton)mockStorage).setMap(mockMap);
	}

	// Test: test that the registerUser(User) method calls the Storage’s add(user) method
	@Test
	public void testRegistrrationExceptionWhenInvalidUserIsPassedInValidator() throws RegistrationException {
		when(mockUser.getUserName()).thenReturn("usernme");
		register.setStorage(mockStorage);
		register.registerUser(mockUser);
		verify(mockStorage, times(1)).add(mockUser);
	}
}
