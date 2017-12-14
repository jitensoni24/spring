package com.bskyb.search.api.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class AppIntegrationTest extends Integration {

	@Test
	public void shouldReturnAppInfo() throws Exception {
		// when and then
		mockMvc.perform(get("/app"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.name", equalTo("s-auth")))
		.andExpect(jsonPath("$.version", equalTo("0.0.1")));
	}

}
