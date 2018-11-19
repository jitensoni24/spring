package com.dtech.web.template.spring.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationS {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext beans = new ClassPathXmlApplicationContext("students-spring.xml");
		
		//changed above class from ApplicationContext to AbstractApplicationContext so I can register the shutdown hook
		//this is important for standalone or desktop application
		beans.registerShutdownHook();
		
		ClassRoom classRoom = beans.getBean("classRoom", ClassRoom.class);
		
		classRoom.getStudentA().getName();
		
		classRoom.getStudentB().getName();
		
		//messageSource bean not defined in the config file / xml file
		String greetingMessage = beans.getMessage("greeting", null, "default", null);
		
		System.out.println(greetingMessage);
		
	}
}
