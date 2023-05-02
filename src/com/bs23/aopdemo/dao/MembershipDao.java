package com.bs23.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	public void addAccount() {
		System.out.println(getClass() + ": Adding the membership account");
	}
	
	public void addSillyWork() {
		System.out.println(getClass() + ": Adding silly work");
	}


}
