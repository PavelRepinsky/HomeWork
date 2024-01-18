package com.company.Homework08_01_2024;

import java.util.Arrays;


public class GetGettersTask3 {

    public static void main(String[] args) {

        Container gc = new Container();

        var getGetters = Arrays.stream(gc.getClass().getDeclaredMethods()).filter(m -> m.getName().startsWith("get") || m.getName().startsWith("is")).toList();

        System.out.println("Все геттреры: " + getGetters);
    }
}
