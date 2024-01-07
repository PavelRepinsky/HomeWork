package com.company.HomeWork25_12_2023;


import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class CollectionUtils<T> {

    static class NewComparator<T extends Comparable<T>> implements java.util.Comparator<T> {
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

    public static ArrayList<Object> list = new ArrayList<>();

    public static<T> void addAll(List<? extends T> source, List<T> destination) {
        destination.addAll(source);
    }

    public static<T> void add(List<? extends T> source, T o) {
        list.add(source.get(source.indexOf(o)));
    }

    public static<T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static<T> int indexOf(List<? extends Integer> source, T o) {
        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(o)) return i;
        }
        return -1;
    }

    public static<T> List<T> limit(List<T> source, int size) {
        List<T> limitedList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            limitedList.add(source.get(i));
        }
        return limitedList;
    }

    public static<T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<T> c1, List<T> c2) {
        boolean b = c1.containsAll(c2);
        return b;
    }

    public static<T> boolean containsAny(List<T> c1, List<T> c2) {
        boolean b = false;
        for (int i = 0; i < c1.size(); i++) {
            Object o = c1.get(i);
            for (int j = 0; j < c2.size(); j++) {
                if (c1.get(i).equals(c2.get(j))) {
                    b = true;
                    break;
                }
            }
        } return b;
    }

    public static<T> List<T> range(List<T> list, T min, T max) {
        list.sort(new NewComparator());

        int minBorder = list.indexOf(min);
        int maxBorder = list.indexOf(max);

        if(!containsAll(list, List.of(min, max))) {
            System.out.println("Указанные min и max отсутствуют в списке!");
        }
        return list.subList(minBorder, maxBorder);
    }

    public static<T> List<T> range1(List<T> list, T min, T max, Comparator<T> comparator) {
        list.sort(comparator);

        int minBorder = list.indexOf(min);
        int maxBorder = list.indexOf(max);

        if(!containsAll(list, List.of(min, max))) {
            System.out.println("Указанные min и max отсутствуют в списке!");
        }
        return list.subList(minBorder, maxBorder);
    }


    public static void main(String[] args) {

        //Проверка newArrayList
        System.out.println("Новый пустой список: " + CollectionUtils.newArrayList());
        System.out.println("______________");

        //Проверка containsAll
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);

        System.out.println("Первый список содержит все элементы из второго? " + CollectionUtils.containsAll(list1, list2));

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("kek");

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("kek");

        System.out.println("Первый список содержит все элементы из второго? " + containsAll(list3, list4));
        System.out.println("______________");

        //Проверка containsAny
        System.out.println("Первый список содержит что-либо из второго? " + containsAny(list1, list2));
        System.out.println("______________");

        //Проверка add
        add(list1, 5);
        System.out.println("Список с добавленным в него значением из другого списка: " + list);
        System.out.println("______________");

        //Проверка addAll
        addAll(list1, list);
        System.out.println("Список со всеми добавленными в него значениями из другого списка: " + list);
        System.out.println("______________");

        //Проверка indexOf
        System.out.println("Индекс запрашиваемого элемента в списке: " + indexOf(list1, 6));
        System.out.println("______________");

        //Проверка limit
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("kek");
        list5.add("kek");
        list5.add("kek");
        list5.add("kek");
        list5.add("kek");
        list5.add("kek");

        System.out.println("Новый лимитированный список: " + limit(list5, 3));
        System.out.println("______________");

        //Проверка range
        System.out.println("Новый список, содержащий эементы согласно установленной границе: " + range(list1, 3, 5));
        System.out.println("______________");

        //Проверка range1
        System.out.println("Новый список, содержащий эементы согласно установленной границе: " + range(list1, 2, 6));
        System.out.println("______________");

        //Проверка removeAll
        System.out.println("Текущий список: " + list1);
        removeAll(list1, list2);
        System.out.println("Удалены ли все элементы из списка? текущий список: " + list1);
        System.out.println("______________");
    }
}
