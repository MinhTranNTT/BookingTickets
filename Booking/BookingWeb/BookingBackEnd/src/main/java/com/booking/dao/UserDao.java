package com.booking.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.booking.common.entity.User;

@Repository
public class UserDao {
	
	@Autowired private SqlSession sqlSession;
	
	public int createNewUser(User user) {
		return sqlSession.insert("createNewUser", user);
	};
	
	public int createRolesNewUser(Map<String, Object> map) {
		return sqlSession.insert("createRolesNewUser", map);
	}
}
