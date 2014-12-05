package com.fdm.model;

import java.util.Map;

import com.fdm.model.storage.MapUserStorage;

public class MapUserStorageSingleton implements MapUserStorage {

	private static MapUserStorageSingleton instance = null;
	private Map<String, User> map;
	private User user;

	public MapUserStorageSingleton() {
		// Exists only to defeat instantiation.
	}

	public static MapUserStorageSingleton getInstance() {
		if (instance == null) {
			instance = new MapUserStorageSingleton();
		}
		return instance;
	}

	public void add(User user) {
		map.put(user.getUserName(), user);
	}

	public User get(String key) {
		user = map.get(key);
		return user;
	}

	public void remove(String key) {
		map.remove(key);
	}

	public void setMap(Map<String, User> map) {
		this.map = map;
	}
}
