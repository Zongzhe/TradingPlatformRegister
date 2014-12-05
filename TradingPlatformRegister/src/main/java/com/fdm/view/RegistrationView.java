package com.fdm.view;

import java.util.Scanner;

import com.fdm.model.User;

public class RegistrationView implements View {

	private Scanner scanner;

	public RegistrationView() {
		setScanner(scanner);
	}

	public void setScanner(Scanner scan) {
		this.scanner = scan;
	}

	// Get input from scanner and holds those values in the correct fields.
	public User getInput() {

		User user = new User();
		// First is username
		user.setUserName(scanner.nextLine());
		// Then is password
		user.setPassword(scanner.nextLine());
		// Then is first name
		user.setFirstName(scanner.nextLine());
		// Then is last name
		user.setLastName(scanner.nextLine());

		scanner.close();
		return user;
	}

	public void display(String str) {
		// TODO Auto-generated method stub

	}

}
