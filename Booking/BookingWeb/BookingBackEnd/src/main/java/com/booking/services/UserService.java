package com.booking.services;

import java.util.Map;

import com.booking.common.entity.User;

public interface UserService {
	
	public int createNewUser(User user, String roles);
	
	public int createRolesNewUser(Map<String, Object> map);
	
}
