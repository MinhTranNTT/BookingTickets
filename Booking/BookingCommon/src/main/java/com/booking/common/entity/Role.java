package com.booking.common.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
	
	private Integer id;
	private String name;
	private String description;
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
