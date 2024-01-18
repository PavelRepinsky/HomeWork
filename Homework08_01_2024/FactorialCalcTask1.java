package com.company.Homework08_01_2024;

import java.util.Scanner;

public class FactorialCalcTask1 implements Calculator{
    @Override
    public int calc(int number) throws InterruptedException {
        if (number <= 1) {
            Thread.sleep(100);
            return 1;
        } else {
            Thread.sleep(100);
            return number * calc(number - 1);
        }
    }

//    public static void main(String[] args) {
//
//        FactorialCalcTask1 factorialCalc = new FactorialCalcTask1();
//
//        Scanner scan = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Enter a number: ");
//            int number = scan.nextInt();
//
//            System.out.println("The factorial of " + number + " is: " + factorialCalc.calc(number));
//        }
//    }
}
