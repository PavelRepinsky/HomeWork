package com.company.Homework28_12_2023;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        MessagesForUser.NotEnoughMoneyMessage();
    }
}
