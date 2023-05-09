package com.bs23.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcutexpression {
	@Pointcut("execution(* com.bs23.aopdemo.dao.*.getAllAccounts(..))")
	public void executionAfter() {}
	
	@Pointcut("execution(* com.bs23.aopdemo.dao.*.findAccount(..))")
	public void thrwoingAfter() {}
	
	@Pointcut("execution(* com.bs23.aopdemo.service.*.*(..))")
	public void aroudAspect() {}
}
