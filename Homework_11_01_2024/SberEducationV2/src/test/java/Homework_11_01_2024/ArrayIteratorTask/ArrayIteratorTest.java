package Homework_11_01_2024.ArrayIteratorTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ArrayIteratorTest {

    @Test
    public void testArrayIterator_WorkWithVariousElements() {
        ArrayIterator<Object> arrayIterator = new ArrayIterator<>(new Object[]{1, "dva", 3.14, true});
            Object element = arrayIterator.next();
            assert(element.equals(1));
            element = arrayIterator.next();
            assert(element.equals("dva"));
            element = arrayIterator.next();
            assert(element.equals(3.14));
            element = arrayIterator.next();
            assert(element.equals(true));

        System.out.println("Test passed!");
        }

    @Test
    public void testArrayIterator_sequenceOfElements() {
        Integer[] array = new Integer[5];
        for (int i = 0; i < 5; i++) {
            array[i] = i + 1;
        }
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(array);

        Object element = arrayIterator.next();
        assert(array[0] == element);
        element = arrayIterator.next();
        assert(array[1] == element);
        element = arrayIterator.next();
        assert(array[2] == element);
        element = arrayIterator.next();
        assert(array[3] == element);
        element = arrayIterator.next();
        assert(array[4] == element);

        System.out.println("Test passed!");
    }

    @Test
    public void testArrayIterator_emptyArray() {
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(new Integer[0]);

        Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, arrayIterator::next);
        assertEquals("No more elements in the array", exception.getMessage());
        System.out.println("Test passed!");
    }

    @Test
    public void testArrayIterator_nullArray() {
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(null);

        Exception exception = Assertions.assertThrows(NullPointerException.class, arrayIterator::next);
        assertEquals("Cannot read the array length because \"this.array\" is null", exception.getMessage());
        System.out.println("Test passed!");
    }
}
