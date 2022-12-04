package com.booking.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.booking", "com.booking.services"})
public class BookingBackEndApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookingBackEndApplication.class, args);
	}
	
}
