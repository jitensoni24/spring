package com.dtech.web.template.spring.aspect;

import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
	
	@Around("@annotation(com.dtech.web.template.spring.aspect.LogTime)")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		jp.proceed();
		
		
		sw.stop();
		
		System.out.println("Time taken to execute method : " + sw.getTime() + "  start time was : " + sw.getStartTime());
		
		return jp;
	}
}
