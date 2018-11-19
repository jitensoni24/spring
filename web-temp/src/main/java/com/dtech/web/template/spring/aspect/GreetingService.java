package com.dtech.web.template.spring.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	@Autowired
	private Greet greet;
	
	@LogTime
	public void callGreet(String name) {
		greet.setWho(name);
		
		try {
			
			System.out.println(greet.getWho());
			
		} catch (InterruptedException e) {}
	}
}
