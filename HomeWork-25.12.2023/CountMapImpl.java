package com.company.HomeWork25_12_2023;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.util.*;

public class CountMapImpl<T> implements CountMap<T> {

    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T t) {
        Integer value = map.get(t);
        if (value == null) {
            map.put(t, 1);
        }
        else {
            map.put(t, ++value);
        }
    }

    @Override
    public int getCount(T t) {
        return map.getOrDefault(t, 0);
    }

    @Override
    public int remove(T t) {
        Integer value = map.get(t);
        if (value == null) {
            System.out.println("Данных для удаления элементов не найдено");
            return 0;
        }
        else {
            map.remove(t);
            System.out.println("Количество повторений удалённого элемента: " + value);
            return value;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        for (T t: source.toMap().keySet()) {
            Integer value = map.get(t);
            if (value == null) {
                map.put(t, 1);
            }
            else {
                map.put(t, ++value);
            }
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
    public static void main(String[] args) {

        CountMap<Integer> map = new CountMapImpl<Integer>();

        map.add(5);
        map.add(5);
        map.add(7);

        System.out.println("Количество запрашиваемых элементов: " + map.getCount(5));
        System.out.println("Количество запрашиваемых элементов: " + map.getCount(7));
        System.out.println("Количество уникальных элементов: " + map.size());

        System.out.println("__________________");

        map.remove(5);
        System.out.println("Количество запрашиваемых элементов: " + map.getCount(5));
        System.out.println("Количество уникальных элементов: " + map.size());
        map.remove(9);
        System.out.println("__________________");

        System.out.println("Мапа: " + map.toMap());

        System.out.println("__________________");

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map.toMap(map2);
        System.out.println("Мапа2: " + map2);

        System.out.println("__________________");

        CountMap<Integer> map3 = new CountMapImpl<>();
        map3.add(6);
        map.addAll(map3);

        System.out.println("Мапа1 после добавления в неё значений из map3: " + map.toMap());
        System.out.println("__________________");
    }
}
