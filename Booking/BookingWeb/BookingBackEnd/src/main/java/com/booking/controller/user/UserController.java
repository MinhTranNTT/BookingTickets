package com.booking.controller.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.booking.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
	
	@Autowired private RoleService roleService;
	@Autowired private UserService userService;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		System.out.println("Users");
		return "account/users";
	}

	@GetMapping("/users-list")
	public String getUserList() {

		List<User> listUser = userService.getListAllUser();

		return "users-list";
	}
	
	@PostMapping(path = "/create_user")
	@ResponseBody
	public String createUser(@ModelAttribute User user, @RequestParam("strRoles") String roles, @RequestParam("image") MultipartFile multipartFile) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (!multipartFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			user.setPhotos(fileName);
			processStringRoles(user, roles);
			userService.createNewUser(user, roles);
			map.put("user", user);
			map.put("roles", user.getRoles());
//			userService.createRolesNewUser(user.getId(), roles);
			userService.createRolesNewUser(map);
			String uploadDir = "user-photos/" + user.getId(); 
			
			try {
				FileUploadUtil.cleanDir(uploadDir);
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			if (user.getPhotos().isEmpty()) {
				user.setPhotos(null);
			}
			userService.createNewUser(user, roles);
		}


		System.out.println(user);
		return "Hey OK";
	}
	
	@SuppressWarnings("null")
	private void processStringRoles(User user, String roles) {
		String[] arrRoles;
		Set<Integer> targetSet = null;
		if (!roles.isEmpty()) {
			arrRoles = roles.split(",");
			Integer[] arr = new Integer[arrRoles.length];
			for (int i=0; i<arrRoles.length; i++) {
				Integer temp = Integer.parseInt(arrRoles[i]);
				arr[i] = temp;
			}
			targetSet = new HashSet<Integer>(Arrays.asList(arr));
			user.setRoles(targetSet);
		}
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
