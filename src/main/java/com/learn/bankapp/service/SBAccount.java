package com.learn.bankapp.service;

/*
 * create a class SBAccount which extends Account
 * define the following attributes:
 * minBalance as double
 * implement the following methods:
 * withdraw: Throw an insufficient balance exception if the balance is not available add the debit transaction to the TransactionList for each withdrawal
 */
import java.time.LocalDate;

import com.learn.bankapp.exception.InsufficientBalanceException;
import com.learn.bankapp.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SBAccount extends Account {
    private double minBalance;

    //create a constructor with the following parameters
    public SBAccount(int accountNumber, double balance, LocalDate openingDate, double minBalance) {
        super(accountNumber, balance, openingDate);
        this.minBalance = minBalance;
    }





    public void withdraw(double amount) {
        if (getBalance() - amount < minBalance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        Transaction transaction = Transaction.builder().date(LocalDate.now()).type(Transaction.Type.DEBIT).amount(amount).build();
        getTransactionList().add(transaction);
        setBalance(getBalance() - amount);


    }

    @Override
    public String getAccountDetails() {
        return "SBAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", transactionList=" + getTransactionList() +
                ", balance=" + getBalance() +
                ", openingDate=" + getOpeningDate() +
                ", minBalance=" + minBalance +
                '}';
    }
}