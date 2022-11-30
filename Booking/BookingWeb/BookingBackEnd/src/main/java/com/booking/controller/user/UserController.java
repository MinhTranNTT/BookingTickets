package com.booking.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking.common.entity.User;

@Controller
public class UserController {
	
	@GetMapping("/users")
	public String listAll(Model model) {
		System.out.println("Users");
		return "account/users";
	}
	
	@PostMapping(path = "/users/create_user")
	public String createUser(@ModelAttribute User user) {
		System.out.println(user);
		return "Hey OK";
	}
	
	
}
