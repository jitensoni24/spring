package com.dtech.web.template.spring.message;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationM {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//changed above class from ApplicationContext to AbstractApplicationContext so I can register the shutdown hook
		//this is important for stand-alone or desktop application
		context.registerShutdownHook();

		String greetingMessage = context.getMessage("greeting", new Object[] {"jitendra"}, "default", null);
		
		System.out.println(greetingMessage);
		
	}
}
