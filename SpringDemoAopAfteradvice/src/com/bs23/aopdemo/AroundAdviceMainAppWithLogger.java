package com.bs23.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs23.aopdemo.dao.Account;
import com.bs23.aopdemo.dao.AccountDao;
import com.bs23.aopdemo.dao.MembershipDao;
import com.bs23.aopdemo.service.TrafficFortuneService;

public class AroundAdviceMainAppWithLogger {

	private static Logger myLogger = Logger.getLogger(AroundAdviceMainAppWithLogger.class.getName());
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(
				"trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Calling traffic fortune service: ");
		String fortuneService = trafficFortuneService.getFortune();
		myLogger.info("Finished");
		
		context.close();
	}

}
