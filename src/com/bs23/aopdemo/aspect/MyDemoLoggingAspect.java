package com.bs23.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	@Before("execution(public void com.bs23.aopdemo.dao.AccountDao.addAccount(com.bs23.aopdemo.dao.Account, ..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing before advice addAccount()");
	}
	
	// matching method name by using wildCard
	@Before("execution(public void add*())")
	public void beforeAddany() {
		System.out.println("\n======>>> Executing before anything start with add");
	}
	
	// match by using return type
	@Before("execution(boolean add*())")
	public void beforeReturntype() {
		System.out.println("\n======>>> Executing before anything start with add and has a return type of boolean");
	}
	
	// match any method by using package
	@Before("execution(* com.bs23.aopdemo.dao.*.*(..))")
	public void beforeSpecificPackage() {
		System.out.println("\n======>>> Executing before any method which is inside a specific package");
	}
}
