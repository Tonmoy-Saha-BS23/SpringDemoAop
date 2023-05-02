package com.bs23.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs23.aopdemo.dao.Account;
import com.bs23.aopdemo.dao.AccountDao;
import com.bs23.aopdemo.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring controller
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		// call the business method
		accountDao.addAccount(new Account(), true);
		accountDao.addChecker();
		
		// call the membership buisnessMethod
		membershipDao.addAccount();
		membershipDao.addSillyWork();
		
		// close the context
		context.close();
	}

}
