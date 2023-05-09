package com.bs23.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.test.context.support.AnnotationConfigContextLoaderUtils;

@Component
public class AccountDao {
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + ": Doing My DB work");
	}
	
	public boolean addChecker() {
		System.out.println(getClass() + ": Doing some checking: Boolean");
		return true;
	}
	
	public List<Account> getAllAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		
		myAccounts.add(new Account("Tonmoy", 19));
		myAccounts.add(new Account("Saha", 29));
		
		return myAccounts;
	}
	
	public Account findAccount(List<Account> accounts,  int id) {
		return accounts.get(id);
	}
}
