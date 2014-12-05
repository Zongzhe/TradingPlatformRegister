package com.fdm.controller;

import com.fdm.actions.Login;
import com.fdm.model.User;
import com.fdm.validators.LoginException;
import com.fdm.validators.LoginValidator;
import com.fdm.view.LoginView;

/*
 * LoginController class: to handle the register process of the user.
 * 
 * @Author: Zongzhe Chen Create Time: 03/12/2014
 */

public class LoginController {

	private LoginView logView;
	private LoginValidator logVali;
	private Login login;

	// Setup the logView, LoginValidator, and Login
	public LoginController(LoginView logView, LoginValidator logVali,
			Login login) {
		setLogin(login);
		setVal(logVali);
		setView(logView);
	}

	// Handle the login: first get the user from input, then validate it.
	// If succeed, login the user. If not, throw an exception.
	public void handle() throws LoginException {
		User user = logView.getInput();

		logVali.Loginvalidate(user);
		login.loginUser(user);

	}

	public void setView(LoginView logView) {

		this.logView = logView;
	}

	public void setVal(LoginValidator logVali) {
		this.logVali = logVali;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
