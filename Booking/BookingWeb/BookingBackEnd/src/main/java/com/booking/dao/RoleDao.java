package com.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.booking.common.entity.Role;

@Repository
public class RoleDao {
	
	@Autowired SqlSession sqlSession;
	
	public List<Role> getListRoles() {
		return sqlSession.selectList("getListRoles");
	}
	
}
