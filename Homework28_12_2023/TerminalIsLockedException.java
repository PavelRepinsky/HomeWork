package com.company.Homework28_12_2023;

public class TerminalIsLockedException extends Exception {
    public TerminalIsLockedException() {
        MessagesForUser.TerminalIsLockedMessage();
    }
}
