package com.bs23.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bs23.aopdemo.dao.Account;
import com.bs23.aopdemo.dao.AccountDao;
import com.bs23.aopdemo.dao.MembershipDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from the spring controller
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		
		List<Account> allAccounts = accountDao.getAllAccounts();
		
		System.out.println("AllAccounts:\n---------\n" + allAccounts +"\n---------");
		
		try {
			Account account = accountDao.findAccount(allAccounts, 3);
			System.out.println(account);
		}catch (Exception e) {
			System.out.println(e);
		}
		context.close();
	}

}
