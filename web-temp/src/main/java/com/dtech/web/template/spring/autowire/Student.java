package com.dtech.web.template.spring.autowire;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	private String name;

	public String getName() {
		System.out.println("Class Student: getname called : " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Class Student: initializing bean: to perform custom initialization, or merely to check that all mandatory properties have been set");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Class Student: Destroying bean : BeanFactory callback to removed singleton instance");		
	}
}


/*

Started with this before implementing interfaces

public class Student {
	private String name;

	public String getName() {
		System.out.println(" get name called : " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

*/