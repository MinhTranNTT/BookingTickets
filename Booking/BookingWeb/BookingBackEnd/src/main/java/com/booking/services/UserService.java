package com.booking.services;

import com.booking.common.entity.User;

public interface UserService {
	
	public int createNewUser(User user, String roles);
}
