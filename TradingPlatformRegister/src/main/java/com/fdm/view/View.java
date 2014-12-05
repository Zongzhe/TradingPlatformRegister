package com.fdm.view;

import com.fdm.model.User;

public interface View {
	
	public User getInput();
	
	public void display(String str);
}
