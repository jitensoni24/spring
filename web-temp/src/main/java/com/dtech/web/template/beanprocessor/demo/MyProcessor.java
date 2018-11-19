package com.dtech.web.template.beanprocessor.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Factory hook that allows for custom modification of new bean instances, 
 * This will run checks for marker interfaces or wrapping them with proxies.
 * Creating this(myprocess) class is not enough, this needs to be registred in the spring xml or config class
 * @author sonijit
 *
 */
public class MyProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Class MyProcessor: After Bean is Fully initialized - bean class - " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Class MyProcessor: Before Bean is Fully initialized - bean class - " + beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		//propertyplaceholderconfigurer is best example of this beanfactory
		
	}
}
