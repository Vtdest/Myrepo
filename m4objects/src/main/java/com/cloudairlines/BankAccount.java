package com.cloudairlines;

public class BankAccount {

    private double balance;
    private double interest;

    BankAccount() {
        this(0);
    }

    BankAccount(double balance) {
        this(balance, 0.1);
    }

    BankAccount(double balance, double interest) {
        if (interest < 0) {
            throw new IllegalArgumentException("Interest rate can't be less than 0");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Starting balance can't be less than 0");
        }
        this.balance = balance;
        this.interest = interest;
    }
}
