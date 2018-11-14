package com.dtech.web.template.controller;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	ApplicationContext context;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public String web() {
		
		System.out.println("web controller");
		
		return "{\"hello\": \"hi\"}";
	}
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public String json() throws Exception {
		
		System.out.println("json controller");
		
		Resource resource = context.getResource("classpath:sample.json");
		
		String string = IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
		
		return string;
	}
}
