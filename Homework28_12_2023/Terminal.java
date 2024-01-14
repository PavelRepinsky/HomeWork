package com.company.Homework28_12_2023;

public interface Terminal {

    // Balance
    int getBalance();

    void withdraw(int amount) throws NotEnoughMoneyException, NotMultipleOfHundredException;

    void deposit(int amount) throws NotMultipleOfHundredException;
}
