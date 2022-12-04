package com.booking.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.common.entity.Role;
import com.booking.dao.RoleDao;
import com.booking.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired RoleDao roleDao;
	
	@Override
	public List<Role> getListRoles() {
		return roleDao.getListRoles();
	}

}
