package com.company.Homework21_12_2023;

import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook {
    public static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void add(String surname, String phoneNumber){
        if (phoneBook.get(surname) == null) {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname, phoneNumbers);
        }
        else {
            phoneBook.get(surname).add(phoneNumber);
        }
    }

    public static ArrayList<String> get(String surname){
        return phoneBook.get(surname);
    }

    public static void main(String[] args) {

        //Проверяем работу метода 'add'
        PhoneBook.add("Иванов", "+79191112233");
        PhoneBook.add("Сидоров", "+79882223311");
        PhoneBook.add("Смирнов", "+79283332233");
        PhoneBook.add("Корчагин", "+79357778899");
        PhoneBook.add("Тихонов", "+79664445566");
        PhoneBook.add("Тихонов", "+79664445567");

        for (String surname: phoneBook.keySet()) {
            ArrayList<String> value = phoneBook.get(surname);
            System.out.println(surname + " --> " + value);
        }

        System.out.println("__________________________________________");

        //Проверяем работу метода 'get'
        System.out.println("По фамилии Иванов в телефонном справочнике есть следующие номера телефонов: " + PhoneBook.get("Иванов"));
        System.out.println("По фамилии Смирнов в телефонном справочнике есть следующие номера телефонов: " + PhoneBook.get("Смирнов"));
        System.out.println("По фамилии Корчагин в телефонном справочнике есть следующие номера телефонов: " + PhoneBook.get("Корчагин"));
        System.out.println("По фамилии Тихонов в телефонном справочнике есть следующие номера телефонов: " + PhoneBook.get("Тихонов"));
        System.out.println("По фамилии Сидоров в телефонном справочнике есть следующие номера телефонов: " + PhoneBook.get("Сидоров"));
    }
}

