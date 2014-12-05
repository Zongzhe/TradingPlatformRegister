package com.fdm.validators;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;


public class RegistrationValidator {

	private boolean	valid = true;
	private Storage	storage;

	public RegistrationValidator() {

	}

	public void validate(User user) throws RegistrationException {
		if(storage.get(user.getUserName()) != null){
			throw new RegistrationException("User invalid!");
		}
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
