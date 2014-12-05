package com.fdm.actions;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

/*
 * Login class: to handle the register process of the user.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class Register {
	
	Storage storage;

	// Set the storage for future use.
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Register() {

	}

	// register by adding the user to the storage
	public void registerUser(User user) {

		storage.add(user);
	}
}
