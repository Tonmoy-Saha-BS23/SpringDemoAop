package com.bs23.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + ": Doing My DB work");
	}
	
	public boolean addChecker() {
		System.out.println(getClass() + ": Doing some checking: Boolean");
		return true;
	}
}
