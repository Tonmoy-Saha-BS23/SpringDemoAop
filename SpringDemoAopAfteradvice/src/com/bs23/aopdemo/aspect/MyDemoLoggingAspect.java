package com.bs23.aopdemo.aspect;

import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.bs23.aopdemo.dao.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	@AfterReturning(pointcut="com.bs23.aopdemo.aspect.Pointcutexpression.executionAfter()"
			, returning = "result")
	public void executionAfter(JoinPoint theJoinpoint, List<Account> result) {
		
		String method = theJoinpoint.getSignature().toShortString();
		myLogger.info("===> Execution after function execution <====");
		myLogger.info(method);
		myLogger.info("Result from after advice: " + result);
		
		// modify the data before it goes to the main application
		convertAccountNameToUpperCase(result);
		
	}
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		for(Account tempAccount:result) {
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
	}
	
	@AfterThrowing(pointcut="com.bs23.aopdemo.aspect.Pointcutexpression.thrwoingAfter()"
			, throwing="exc")
	public void throwingException(
			JoinPoint thJoinPoint, Throwable exc) {
		
		String method = thJoinPoint.getSignature().toShortString();
		myLogger.info("======> Executing afterthrowing :"+ method);
		myLogger.info("====> "+ exc);
	}
	
	@After("com.bs23.aopdemo.aspect.Pointcutexpression.thrwoingAfter()")
	public void afterFinally(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> Executing after finally block" + method);
	}
}
