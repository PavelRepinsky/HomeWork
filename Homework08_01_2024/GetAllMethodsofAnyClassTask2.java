package com.company.Homework08_01_2024;

import java.util.Arrays;

public class GetAllMethodsofAnyClassTask2 {

    public static void main(String[] args) {

        Child child = new Child();
        System.out.println("Все методы, включая private: " + Arrays.toString(child.getClass().getDeclaredMethods()) + "\n");
        System.out.println("Методы без private: " + Arrays.toString(child.getClass().getMethods()));
    }
}
