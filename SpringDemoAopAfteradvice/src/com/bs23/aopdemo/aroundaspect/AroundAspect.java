package com.bs23.aopdemo.aroundaspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	@Around("com.bs23.aopdemo.aspect.Pointcutexpression.aroudAspect()")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>> Executing @Around on method" + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info("Total duration: " + duration / 1000.0 + "seconds");
		return result;
	}
	
}
