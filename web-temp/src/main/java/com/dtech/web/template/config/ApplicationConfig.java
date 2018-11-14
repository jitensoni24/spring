package com.dtech.web.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "com.bskyb.web.template")
public class ApplicationConfig {

	@Bean
	public ObjectMapper mapper() {
		System.out.println("object mapper bean created by spring...");
		return new ObjectMapper();
	}
}
