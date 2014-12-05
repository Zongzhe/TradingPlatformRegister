package com.fdm.test.model;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.fdm.model.MapUserStorageSingleton;
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

public class MapUserStorageSingletonTest {

	private User					mockUser;
	private Storage					mockStorage;
	private MapUserStorageSingleton	muss;
	private Map<String, User>		mockMap;

	// Before: create and initialise the controller class
	@SuppressWarnings ("unchecked")
	@Before
	public void setup() {

		mockUser = Mockito.mock(User.class);
		mockStorage = Mockito.mock(Storage.class);
		muss = new MapUserStorageSingleton();
		mockMap = Mockito.mock(Map.class);
		muss.setMap(mockMap);

	}

	// Test: The get function in user class is called when the program calls the put function
	@Test
	public void testGetIsCalledWhenCallingPut() {

		muss.add(mockUser);
		verify(mockUser, times(1)).getUserName();
	}
	
	// Test: The get function in user class is called when the program calls the put function
		@Test
		public void testReturnUserWhenGetIsCalled() {

			String key = "username";
			
			when(mockMap.get(key)).thenReturn(mockUser);
			assertEquals(mockUser, muss.get(key));
		}


}
