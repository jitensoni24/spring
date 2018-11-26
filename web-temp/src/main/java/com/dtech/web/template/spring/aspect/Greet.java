package com.dtech.web.template.spring.aspect;

import org.springframework.stereotype.Component;

@Component
public class Greet {

	private String who;

	public String getWho() throws InterruptedException {
		
		Thread.sleep(1000);
		
		return who;
	}
	
	public String getWho(String name) {
		return this.who + " and you are : " + name;
	}

	public void setWho(String who) {
		this.who = who;
	}
	
	public String whoAmI(String who) {
		return this.who + " told you are : " + who;
	}
	
	public String whoAmI() {
		return who;
	}
}
