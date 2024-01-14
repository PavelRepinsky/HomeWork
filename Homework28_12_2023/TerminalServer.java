package com.company.Homework28_12_2023;

public class TerminalServer {

    public static int balance = 100;

    public static void withdraw(int amount) throws NotEnoughMoneyException, NotMultipleOfHundredException {
        if (balance < amount) {throw new NotEnoughMoneyException();}
        else if (amount > 0 && amount % 100 == 0) {
            balance -= amount;
        }
        else {
            throw new NotMultipleOfHundredException();
        }
    }

    public static void deposit(int amount) throws NotMultipleOfHundredException {
        if (amount > 0 && amount % 100 == 0) {
            TerminalServer.balance += amount;
        } else {
            throw new NotMultipleOfHundredException();
        }
    }
}
