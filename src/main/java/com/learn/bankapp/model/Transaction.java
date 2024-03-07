package com.learn.bankapp.model;

/*
 * create a class Transaction with the following attributes:
 * date as a object of LocalDate
 * type as enum with values debit and credit
 * amount as double
 * implement builder pattern to create the object of Transaction
 * lombok annotations to create the getters and setters
 */
import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Transaction {
    private LocalDate date;
    private Type type;
    private double amount;

    public enum Type {
        DEBIT, CREDIT
    }
   
}





