package com.company.Homework08_01_2024;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class StringConstantsTask4 {

    public static void main(String[] args) {
        Container container = new Container();

        final var constants = Arrays.stream(container.getClass().getDeclaredFields()).filter(field -> field.getType() == String.class &&
                Modifier.isPublic(field.getModifiers()) &&
                Modifier.isStatic(field.getModifiers()) &&
                Modifier.isFinal(field.getModifiers())).allMatch(field -> {
            try {
                return field.get(container).equals(field.getName());
            } catch (IllegalAccessException e) {
                return false;
            }
        });

        System.out.println(constants);
    }
}
