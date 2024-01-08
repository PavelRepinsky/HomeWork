package com.company.Homework18_12_2023;

public abstract class Parent {

    private String name;

    static {
        System.out.println("Parent:static 1");
    }

    {
        System.out.println("Parent:instance 1");
    }

    static {
        System.out.println("Parent:static 2");
    }

    {
        System.out.println("Parent:instance 2");
    }

    //Конструкторы
    public Parent() {
        System.out.println("Parent:constructor");
    }

    public Parent(String name) {
        System.out.println("Parent:name-constructor");
    }
}
