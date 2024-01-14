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
                    throw new TerminalIsLockedException();}
                else {break;}}
            catch (TerminalIsLockedException e){
                scanner.nextLine();
            }
        }
        System.out.println("Terminal is unlocked!");}
}