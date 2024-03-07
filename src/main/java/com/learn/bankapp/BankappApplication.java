package com.learn.bankapp;



import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.bankapp.service.Account;
import com.learn.bankapp.service.FDAccount;
import com.learn.bankapp.service.SBAccount;



@SpringBootApplication
public class BankappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
		//print the message
		System.out.println("Welcome to Bank Application");


		//deposit the amount
		Account account = new SBAccount(1, 1000, LocalDate.now(), 500);
		System.err.println("Deposit 1000");
		account.deposit(1000);
		//print the account details
		System.out.println(account.getAccountDetails());
		//create new FDAccount object
		Account account1 = new FDAccount(2, 10000, LocalDate.now(), LocalDate.now().plusMonths(12), 5);
		//print the account details
		System.out.println(account1.getAccountDetails());
		//withdraw the amount
		System.out.println("Withdraw 500");
		((SBAccount) account).withdraw(500);
		//test insufficient balance exception
		try{
			//withdraw the amount
			System.out.println("Withdraw 1000");
			((SBAccount) account).withdraw(200000);
		}
		catch(Exception e){
			//print the exception message
			System.out.println(e.getMessage());
		}
		
		



		


	}

}
