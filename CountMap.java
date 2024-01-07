package com.company.HomeWork25_12_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CountMap<T> {
    void add(T t);

    int getCount(T t);

    //current count
    int remove(T t);

    int size();

    void addAll(CountMap<T> source);

    Map<T, Integer> toMap();

    void toMap(Map<T, Integer> destination);
}