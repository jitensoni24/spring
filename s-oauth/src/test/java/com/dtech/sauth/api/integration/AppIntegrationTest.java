package com.dtech.sauth.api.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.security.test.context.support.WithMockUser;

public class AppIntegrationTest extends Integration {

	/**
	 * This will only work when the security is not set with httpbasic or formlogin etc...
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username="admin", password="password", roles="ADMIN")
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
	

	/**
	 * In securityconfig configuration 
	 * - uncomment - the configure(http) method httpbasic() code. 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnAppInfo_Security_HttpBasic() throws Exception {
		// when and then
		mockMvc.perform(get("/app").with(httpBasic("admin", "password")))
		.andDo(print())
		.andExpect(status().isForbidden());/*
		.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.name", equalTo("s-auth")))
		.andExpect(jsonPath("$.version", equalTo("0.0.1")))*/;
	}

}
