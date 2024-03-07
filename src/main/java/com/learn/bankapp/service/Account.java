package com.learn.bankapp.service;

/*abstract 
 * create a abstract class Account with the following attributes:
 * accountNumber as int
 * TransactionList as List of Transaction objects
 * balance as double
 * openingDate as object of LocalDate
 *  define the following methods:
 * deposit: add the credit transaction to the TransactionList for each deposit
 * getAccountDetails: return the account details as a string
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.learn.bankapp.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter 
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {
    private int accountNumber;
    private List<Transaction> transactionList;
    private double balance;
    private LocalDate openingDate;

    public Account(int accountNumber, double balance, LocalDate openingDate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.transactionList = new ArrayList<>();
    }
    //create no argument constructor
    public void deposit(double amount) {
        Transaction transaction = Transaction.builder()
                .date(LocalDate.now())
                .type(Transaction.Type.CREDIT)
                .amount(amount)
                .build();
        transactionList.add(transaction);
        balance += amount;
    }

    public abstract String getAccountDetails();

    
}
