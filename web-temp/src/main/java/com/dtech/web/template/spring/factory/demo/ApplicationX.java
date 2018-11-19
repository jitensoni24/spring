package com.dtech.web.template.spring.factory.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationX {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		BeanFactory beans = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
//		ApplicationContext beans = new FileSystemXmlApplicationContext("spring.xml");
		
		Triangle t = context.getBean("triangle", Triangle.class);
		
		t.draw();
	}
}
