package com.booking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	
	private Integer studId;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email;
	}
	
}
