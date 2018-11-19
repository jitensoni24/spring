package com.dtech.web.template.spring.aspect;

import java.util.stream.Stream;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationA {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext beans = new ClassPathXmlApplicationContext("aspect-spring.xml");
		
		//changed above class from ApplicationContext to AbstractApplicationContext so I can register the shutdown hook
		//this is important for standalone or desktop application
		beans.registerShutdownHook();

		GreetingService greetingService = beans.getBean("greetingService", GreetingService.class);
		
		Stream.of("forbidden", "kingdom")
			.forEach(s -> greetingService.callGreet(s));
		
	}
	
}
