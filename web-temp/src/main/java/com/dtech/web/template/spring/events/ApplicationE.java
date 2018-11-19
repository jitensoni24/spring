package com.dtech.web.template.spring.events;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationE {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("event-spring.xml");
		
		//changed above class from ApplicationContext to AbstractApplicationContext so I can register the shutdown hook
		//this is important for stand-alone or desktop application
		context.registerShutdownHook();

		MyEventPublisher myPublisher = context.getBean("myPublisher", MyEventPublisher.class);
		
		@SuppressWarnings("unused")
		Stream<String> fileRows = Files.lines(Paths.get(context.getResource("lamb.csv").getURI().getPath()));

		FileEvent event = new FileEvent(myPublisher);
		
		myPublisher.getPublisher().publishEvent(event);
		
		
		
		
	}
}
