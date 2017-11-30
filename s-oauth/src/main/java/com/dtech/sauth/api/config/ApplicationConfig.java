package com.dtech.sauth.api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/* Indicates that a class declares one or more @Bean methods and may be processed by the 
 * Spring container to generate bean definitions and service requests for those beans at runtime */
@Configuration

/*
 * Enable Spring MVC, content-type and accept header, generally content
 * negotiation requires this
 */
@EnableWebMvc

/*
 * Configures component scanning directives for use with @Configuration classes
 */
@ComponentScan(basePackages = "com.dtech.sauth.api")

/*
 * Enables support for handling components marked with AspectJ's @Aspect
 * annotation
 */
@EnableAspectJAutoProxy
public class ApplicationConfig extends WebMvcConfigurationSupport {

	public ApplicationConfig() {
		System.out.println(" Step - 2 - Initialize beans ApplicationConfig");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}

	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/views/");
		viewResolve.setSuffix(".jsp");

		return viewResolve;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
