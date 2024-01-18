package com.company.Homework08_01_2024;

import java.lang.reflect.Proxy;

public class Task6 {

    public static void main(String[] args) throws InterruptedException {
        Calculator delegate = new FactorialCalcTask1();
        Calculator calc = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), delegate.getClass().getInterfaces(), new PerformanceProxy(delegate));

        System.out.println(calc.calc(1));
        System.out.println(calc.calc(5));
        System.out.println(calc.calc(6));
        System.out.println(calc.calc(1));
        System.out.println(calc.calc(2));
    }
}
