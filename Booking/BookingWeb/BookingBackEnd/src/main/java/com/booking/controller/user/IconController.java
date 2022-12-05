package com.booking.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IconController {
	
	@GetMapping("/icons")
	public String getICON() {
		return "icons";
	}
}
