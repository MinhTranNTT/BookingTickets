package com.booking.common.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	
	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String photos;
	private boolean enabled;
	//private Set<Role> roles = new HashSet<>();
	
	
	public User() {
	}
	
	public User(String email, String password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
