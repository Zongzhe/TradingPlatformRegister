package com.fdm.model.storage;

import com.fdm.model.User;

public interface Storage {

	public User get(String key);
	public void remove(String str);
	public void add(User user);
}
