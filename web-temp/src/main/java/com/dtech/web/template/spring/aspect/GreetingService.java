package com.dtech.web.template.spring.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	@Autowired
	private Greet greet;
	
	@Autowired
	private TimeTeller timeTeller;
	
	public void callGreet(String name) {
		greet.setWho(name);
		
		System.out.println(greet.getWho());
		
		timeTeller.timeCheck();
	}
}
