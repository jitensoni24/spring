package com.dtech.sauth.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtech.sauth.api.entity.Roles;
import com.dtech.sauth.api.entity.User;
import com.dtech.sauth.api.repository.Repository;

@Service
public class UserService {
	
	@Autowired
	Repository<User> userRepository;
	
	@Transactional
	public void initUsers() {
		User u = null;
		List<Roles> roles = new ArrayList<>();
		
		for (int i = 1; i < 5; i++) {
			u = new User();
			u.setUsername("user-"+i);
			u.setPassword("password-"+i);
			u.setActive(true);
			roles = Arrays.asList(new Roles("USER"), new Roles("ADMIN"));
			u.setRoles(new HashSet<Roles>(roles));
			
			userRepository.create(u);
		}
	}

	@Transactional
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	public User get(String username) {
		return userRepository.get(username);
	}
}
