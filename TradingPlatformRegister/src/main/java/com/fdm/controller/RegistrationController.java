package com.fdm.controller;

import com.fdm.actions.Register;
import com.fdm.model.User;
import com.fdm.validators.RegistrationException;
import com.fdm.validators.RegistrationValidator;
import com.fdm.view.RegistrationView;

/*
 * RegistrationController class: to handle the register process of the user.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class RegistrationController {

	private RegistrationView regView;
	private RegistrationValidator regVali;
	private Register register;

	// Setup the RegistrationView, RegistrationValidator and Register
	public RegistrationController(RegistrationView regView,
			RegistrationValidator regVali, Register register) {
		setReg(register);
		setVal(regVali);
		setView(regView);
	}

	// Handle the register: first get the user from input, then validate it.
	// If succeed, register the user. If not, throw an exception.
	public void handle() throws RegistrationException {
		User user;
		user = regView.getInput();

		regVali.validate(user);
		register.registerUser(user);

	}

	public void setView(RegistrationView regView) {

		this.regView = regView;
	}

	public void setVal(RegistrationValidator regVali) {
		this.regVali = regVali;
	}

	public void setReg(Register register) {
		this.register = register;
	}
}
