package com.booking.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/users")
	public String listAll(Model model) {
		System.out.println("Users");
		return "account/users";
	}
	
	
}
