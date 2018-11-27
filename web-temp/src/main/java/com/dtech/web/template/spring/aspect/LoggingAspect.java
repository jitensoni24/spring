package com.dtech.web.template.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private int count = 1;
	
	/**
	 * expression method name : public String getWho()
	 * expression method name with class information: 
	 * 	com.dtech.web.template.spring.aspect.Greet getWho()
	 * 
	 * expression with annotations:
	 *   @annotation(AnnotationAspectName)
	 *   Expression with wild cards:
	 *   	any GET method : public void get*()
	 *   	any GET method with any return type: public * get*()
	 *   	any GET method with any return and any argument: public * get*(*)
	 *   
	 */
	@Before("execution(public String getWho())")
	public void LoggingAdvice() {
		System.out.println("count increment to : " + count++);
	}
	
	//pointcut defined below...
	@Before("allGetWhoAmI()")
	public void LoggingAdviceSecond() {
		System.out.println("count increment to : " + count++);
	}
	
	@Pointcut("execution(public String getWhoAmI(*))")
	public void allGetWhoAmI() {
		
	}
	/**
	 * execution aspect expression is for method(sss)
	 * 
	 * within aspect express is for classessss
	 * 
	 * args aspect captures the arguments passed to the methods put 
	 * same name of argument in the advice method 
	 * eg. @Before("args(name)")
	 *     public void aspectMethod(name <- same name args...) 
	 */
	@Pointcut("within(com.dtech.web.template.spring.aspect.TimeTeller)")
	public void allTimeTellerMethods() {}
	
	//pointcut defined below...
	@Before("allTimeTellerMethods()")
	public void LoggingAdviceTimeteller() {
		System.out.println("count increment to : " + count++);
	}
}
