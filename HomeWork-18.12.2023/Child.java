package com.company.Homework18_12_2023;

public class Child extends Parent{

    //Статические блоки
    static {
        System.out.println("Child:static 1");
    }

    static {
        System.out.println("Child:static 2");
    }

    //Нестатические блоки
    {
        System.out.println("Child:instance 1");
    }

    {
        System.out.println("Child:instance 2");
    }

    //Конструкторы
    public Child() {
        System.out.println("Child:constructor");
    }

    public Child(String name) {
        System.out.println("Child:name-constructor");
    }
}
