package com.fdm.validators;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;


public class LoginValidator {

	private Storage	storage;

	public LoginValidator() {

	}

	public void Loginvalidate(User user) throws LoginException {
		if(storage.get(user.getUserName()) == null){
			throw new LoginException("User invalid!");
		}
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
