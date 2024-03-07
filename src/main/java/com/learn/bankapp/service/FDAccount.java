package com.learn.bankapp.service;

/*
 * create a class FDAccount which extends Account
 * define the following attributes:
 * maturityDate as object of LocalDate
 * interestRate as double
 * implement the following methods:
 * gettenure: return the tenure in months
 * getmaturityAmount: return the maturity amount
 */
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FDAccount extends Account {
    private LocalDate maturityDate;
    private double interestRate;

    //create a constructor with the following parameters
    public FDAccount(int accountNumber, double balance, LocalDate openingDate, LocalDate maturityDate, double interestRate) {
        super(accountNumber, balance, openingDate);
        this.maturityDate = maturityDate;
        this.interestRate = interestRate;
    }

    public int getTenure() {
        return (int) (LocalDate.now().until(maturityDate).toTotalMonths());
    }

    public double getMaturityAmount() {
        return getBalance() + (getBalance() * interestRate * getTenure() / 100);
    }

    @Override
    public String getAccountDetails() {
        return "FDAccount{" +
                "accountNumber=" + getAccountNumber() +
                ", transactionList=" + getTransactionList() +
                ", balance=" + getBalance() +
                ", openingDate=" + getOpeningDate() +
                ", maturityDate=" + maturityDate +
                ", interestRate=" + interestRate +
                '}';
    }
}

