package com.bskyb.search.api.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bskyb.search.api.config.ApplicationConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;


/* @ContextConfiguration defines class-level metadata that is used 
 * to determine how to load and configure an ApplicationContext for integration tests */
@ContextConfiguration(classes = { ApplicationConfig.class })

/*  @WebAppConfiguration on a test class indicates that a WebApplicationContext should be 
 * loaded for the test using a default for the path to the root of the web application */
@WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner.class)

public abstract class Integration {

	public static final Faker fake = Faker.instance();
	
	/* PersistenceContext to be added */
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	protected MockMvc mockMvc;

	@Autowired 
	ObjectMapper mapper;
	
	@Before
	public void init() throws Exception {
		 mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testSpringContextConfiguration() throws Exception {
		
		System.out.println(" Test configuration up ");
	}

    public String getJsonPayload(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
