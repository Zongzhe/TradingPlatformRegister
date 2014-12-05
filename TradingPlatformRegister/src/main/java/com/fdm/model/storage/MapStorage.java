package com.fdm.model.storage;

import java.util.Map;

import com.fdm.model.User;

public interface MapStorage {

	public void setMap(Map<String, User> map);
}
