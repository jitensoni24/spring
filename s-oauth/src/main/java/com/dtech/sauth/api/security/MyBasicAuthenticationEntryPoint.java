package com.dtech.sauth.api.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println(" Step - 6 - MyBasicAuthenticationEntryPoint commence");

		super.commence(request, response, authException);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Step - 7 - MyBasicAuthenticationEntryPoint afterporperties set");

		setRealmName("EXAMPLE_REALM");
		super.afterPropertiesSet();
	}
}
