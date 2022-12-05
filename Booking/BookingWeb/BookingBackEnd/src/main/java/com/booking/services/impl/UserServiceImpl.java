package com.booking.services.impl;

import java.util.Map;

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
		return userDao.createNewUser(user);
	}

	@Override
	public int createRolesNewUser(Map<String, Object> map) {
		return userDao.createRolesNewUser(map);
	}

}
