package com.dtech.sauth.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration

/* */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		System.out.println(" Step - 3 - SecurityConfig.configure(WebSecurity web");
		
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		web.ignoring().antMatchers("/resources/**"); // Spring Security should
														// completely ignore
														// URLs starting with
														// /resources/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println(" Step - 4 - SecurityConfig.configure(HttpSecurity http");

		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/app/**").hasRole("ADMIN")
			/*.and()
			.httpBasic()*/
			// No need session.
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		try {
			
			System.out.println(" Step - 5 - SecurityConfig.configure(AuthenticationManagerBuilder auth");
			
			auth.inMemoryAuthentication()
			.withUser("user").password("password").roles("USER")
			.and()
			.withUser("admin").password("password").roles("USER", "ADMIN");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
