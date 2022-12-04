package com.booking.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.entity.User;
import com.booking.dao.UserDao;
import com.booking.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserDao userDao;
	
	@Override
	public int createNewUser(User user, String roles) {
//		String[] arrRoles;
//		if (!roles.isEmpty() ) {
//			arrRoles = roles.split(",");
//		}
		
		return userDao.createNewUser(user);
	}

}
