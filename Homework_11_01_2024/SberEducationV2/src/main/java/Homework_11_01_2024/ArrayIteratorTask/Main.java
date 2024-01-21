package Homework_11_01_2024.ArrayIteratorTask;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Object[] objArray = {"Hello", 123, true, 3.14, "OpaOpaOpaPa"};

        Iterator<Object> iterator = new ArrayIterator<>(objArray);

        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }
    }
}
