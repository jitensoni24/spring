package com.dtech.web.template.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class TestHomeController {

	@Mock
	ApplicationContext context;
	
	@InjectMocks
	private HomeController homeController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}
	
	@Test
	public void testWebGet() throws Exception {
		//Given 
		
		//When
		ResultActions perform = mockMvc.perform(get("/"));
		
		//Then
		perform
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		//.andExpect(jsonPath("$.hello").doesNotExist());
		.andExpect(jsonPath("$.hello", equalTo("hi")));
		
	}
	
	
	@Test
	public void testJsonWebGet() throws Exception {
		//Given
		ResourceLoader loader = new DefaultResourceLoader();
		Resource resource = loader.getResource("test-sample.json");
		/*System.out.println(IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8));*/
		when(context.getResource("classpath:sample.json")).thenReturn(resource);
		
		
		//When
		ResultActions perform = mockMvc.perform(get("/json"));
		
		
		//Then
		perform
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.name", equalTo("template")))
		.andExpect(jsonPath("$.type", equalTo("web")));
		
		//Verify
		verify(context, times(1)).getResource("classpath:sample.json");
		
	}
}
