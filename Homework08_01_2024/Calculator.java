package com.company.Homework08_01_2024;

public interface Calculator {
    /**
     * Расчёт факториала числа
     * @param number - число;
     */

    @Metric
    int calc (int number) throws InterruptedException;
}
