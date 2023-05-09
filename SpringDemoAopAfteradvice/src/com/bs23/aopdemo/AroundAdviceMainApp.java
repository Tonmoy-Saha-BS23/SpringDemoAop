package com.bs23.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs23.aopdemo.dao.Account;
import com.bs23.aopdemo.dao.AccountDao;
import com.bs23.aopdemo.dao.MembershipDao;
import com.bs23.aopdemo.service.TrafficFortuneService;

public class AroundAdviceMainApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService trafficFortuneService = context.getBean(
				"trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling traffic fortune service: ");
		String fortuneService = trafficFortuneService.getFortune();
		System.out.println("Finished");
		
		context.close();
	}

}
