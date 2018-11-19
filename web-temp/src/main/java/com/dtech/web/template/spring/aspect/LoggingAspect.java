package com.dtech.web.template.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private int count;
	
	@Before("execution(public String getWho())")
	public void LoggingAdvice() {
		System.out.println("count increment to : " + count++);
	}
}
