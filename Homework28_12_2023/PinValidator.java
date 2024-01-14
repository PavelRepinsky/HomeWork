package com.company.Homework28_12_2023;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PinValidator {
    private static int wrongPin = 0;
    private final static ArrayList<Object> correctPinArray = new ArrayList<>();
    private final static ArrayList<Object> pinArray = new ArrayList<>();

    public static void validatePin() {
        correctPinArray.add(1);
        correctPinArray.add(2);
        correctPinArray.add(3);
        correctPinArray.add(4);
        while (true) {
            try {
                if (wrongPin == 3) {
                    System.out.println("You have entered wrong pin 3 times, terminal is locked for 10 seconds!");
                    PinTimer.Countdown();
                    wrongPin = 0;
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a four digit pin number (one digit by one): ");

                for (int i = 0; i < correctPinArray.size(); i++) {
                    pinArray.add(i, scanner.nextInt());
                    if (pinArray.size() < correctPinArray.size()) {System.out.println("Please, enter next digit: ");}
                    if (!pinArray.get(i).equals(correctPinArray.get(i))) {
                        System.out.println("The pin digit you entered is not valid!");
                        pinArray.remove(i);
                        i--;
                    }
                }
                if(pinArray.equals(correctPinArray)) {break;}
            } catch (Exception e) {
                if (wrongPin == 2) {
                    System.out.println("You have entered a wrong symbol!");
                    wrongPin++;
                }
                else {System.out.println("You have entered a wrong symbol, please, try again! :) ");
                    wrongPin++;}
            }
        }
    }
}