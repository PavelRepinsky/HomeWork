package Homework_11_01_2024.ArrayIteratorTask;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int index;

    public ArrayIterator(T[] array) {
        this.array = array;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return array[index++];
        }
        else {
            throw new IndexOutOfBoundsException("No more elements in the array");
        }
    }
}