package com.bskyb.search.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bskyb.search.api.App;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@RestController
public class AppController {

	public static final Faker fake = Faker.instance();

	@Autowired 
	ObjectMapper mapper;
	
	@GetMapping(value = "/app", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String app() throws Exception {
		return getJsonPayload(new App("spring-api", "0.0.1"));
	}
	
    private String getJsonPayload(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
