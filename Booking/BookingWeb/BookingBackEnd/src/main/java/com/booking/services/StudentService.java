package com.booking.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.domain.Student;

@Service
public class StudentService {
	
	@Autowired private SqlSession sqlSession;
	
	public List<Student> getListStudent() {
		List<Student> listStudent = sqlSession.selectList("getListStudent");
		return listStudent;
	}
}
