package com.dtech.web.template.spring.aspect;

import org.springframework.stereotype.Component;

@Component
public class Greet {

	private String who;

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}
}
