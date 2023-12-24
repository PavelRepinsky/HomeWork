package com.company.Homework21_12_2023;


import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //1 задание. Создаем массив на 20 элементов
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Potato", "Tomato", "Carrot", "Cucumber", "Pumpkin",
                "Cabbage", "Eggplant", "Broccoli", "Avocado", "Beet",
                "Onion", "Radish", "Champignon", "Zuccini", "Chili pepper",
                "Cucumber", "Cucumber", "Broccoli", "Carrot", "Cucumber");

        // Создаем второй массив и заполняем его уникальными значениями
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list1.contains(list.get(i))) {
                continue;
            }
            else {
                list1.add(list.get(i));
            }

            //Выводим список уникальных значений и информацию по кол-ву одинаковых слов
            if (Collections.frequency(list, list1.get(i)) == 1) {
                System.out.println("The word \"" + list1.get(i) + "\" appears once");
            }
            else {
                System.out.println("The word \"" + list1.get(i) + "\" appears " + Collections.frequency(list, list1.get(i)) + " times");
            }
        }
    }
}
