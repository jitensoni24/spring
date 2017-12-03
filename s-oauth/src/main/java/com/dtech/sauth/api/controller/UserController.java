package com.dtech.sauth.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.sauth.api.entity.User;
import com.dtech.sauth.api.service.UserService;
import com.github.javafaker.Faker;

@RestController
public class UserController {

	public static final Faker fake = Faker.instance();
	
	@Autowired
	UserService userService;

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> users() throws Exception {
		return userService.getAll();
	}
	

	@GetMapping(value = "/users/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> usersCreate() throws Exception {
		 userService.initUsers();
		 
		 return users();
	}
}
