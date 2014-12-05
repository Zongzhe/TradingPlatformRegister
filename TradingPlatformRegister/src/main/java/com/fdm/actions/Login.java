package com.fdm.actions;

import com.fdm.model.User;
import com.fdm.model.storage.Storage;

/*
 * Login class: to handle the login of the user, including get/set role/enabled function.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class Login {

	Storage storage;
	User user;

	// Set the storage for future use.
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Login() {

	}

	// Some processes during the login of the user.
	public void loginUser(User user) {

		int role = 0;
		boolean enable = false;

		setUserAbility(user, true);
		enable = getUserAbility(user);
		setUserRole(user, 1);
		role = getUserRole(user);

	}

	// Set the role of the user
	public void setUserRole(User user, int i) {
		// TODO Auto-generated method stub
		user.setRole(i);
	}

	// Set the enable of the user
	public void setUserAbility(User user, boolean b) {
		// TODO Auto-generated method stub
		user.setEnable(b);
	}

	// Get the role of the user
	public int getUserRole(User user) {
		// TODO Auto-generated method stub
		int role = user.getRole();
		return role;
	}

	// Get the enable of the user
	public boolean getUserAbility(User user) {
		// TODO Auto-generated method stub
		boolean enable = user.isEnable();
		return enable;
	}
}
