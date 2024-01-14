package com.company.Homework28_12_2023;


import java.util.Scanner;

public class PinTimer {

    public static void Countdown() {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        long lockTime = 10 * 1000;
        while ((System.currentTimeMillis() - startTime) < lockTime) {
            try{
                if (scanner.hasNextLine()) {
                    throw new TerminalIsLockedException(" The terminal is locked. Remaining time: " + (10 - ((System.currentTimeMillis() / 1000) - startTime / 1000)) + " секунд");}}
            catch (TerminalIsLockedException e){
                scanner.nextLine();
            }
        }
        System.out.println("Terminal is unlocked!");}
}