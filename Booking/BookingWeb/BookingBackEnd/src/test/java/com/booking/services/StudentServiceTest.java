package com.booking.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.booking.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StudentServiceTest {

	@Autowired private StudentService studentService;

	@Test
	public void testGetListStudent() {
		List<Student> listStudent = studentService.getListStudent();
		assertNotNull(listStudent);
	}
}
