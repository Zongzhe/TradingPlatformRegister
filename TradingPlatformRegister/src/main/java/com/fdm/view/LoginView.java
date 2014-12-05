package com.fdm.view;

import java.util.Scanner;

import com.fdm.model.User;

public class LoginView implements View {

	private Scanner scanner;

	public LoginView() {
		setScanner(scanner);
	}

	public void setScanner(Scanner scan) {
		this.scanner = scan;
	}

	public void display(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getInput() {
		
		User user = new User();
		// First is username
		user.setUserName(scanner.nextLine());
		// Then is password
		user.setPassword(scanner.nextLine());

		return user;
	}

}
