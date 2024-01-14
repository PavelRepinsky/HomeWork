package com.company.Homework28_12_2023;

import java.util.Scanner;

public class TerminalImpl implements Terminal {

    @Override
    public int getBalance() { return TerminalServer.balance;}

    @Override
    public void withdraw(int amount) throws NotEnoughMoneyException, NotMultipleOfHundredException {
        TerminalServer.withdraw(amount);
    }

    @Override
    public void deposit(int amount) throws NotMultipleOfHundredException {
        TerminalServer.deposit(amount);
    }
}
