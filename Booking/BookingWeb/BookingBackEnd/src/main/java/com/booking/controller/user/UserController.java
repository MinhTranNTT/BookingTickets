package com.booking.controller.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booking.common.entity.Role;
import com.booking.common.entity.User;
import com.booking.services.RoleService;
import com.booking.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(path="/users")
public class UserController {
	
	@Autowired private RoleService roleService;
	@Autowired private UserService userService;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		System.out.println("Users");
		return "account/users";
	}
	
	@PostMapping(path = "/create_user")
	@ResponseBody
	public String createUser(@ModelAttribute User user, @RequestParam("strRoles") String roles) {
		userService.createNewUser(user, roles);
		System.out.println(user);
		return "Hey OK";
	}
	
	@PostMapping(path = "/data_role")
	@ResponseBody
	public String getDataRoles() {
		Gson gson = new GsonBuilder().create();
		HashMap<String, Object> map = new HashMap<>();
		List<Role> listRoles = roleService.getListRoles();
		map.put("listRoles", listRoles);
		
		return listRoles.size() > 0 ? gson.toJson(map) : "400";
	}
	
}
