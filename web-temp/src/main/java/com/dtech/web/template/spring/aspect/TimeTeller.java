package com.dtech.web.template.spring.aspect;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeTeller {
	public void timeCheck() {
		System.out.println("Time now is : " + new Date());
	}
}
