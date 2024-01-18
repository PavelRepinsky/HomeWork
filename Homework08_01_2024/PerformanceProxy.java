package com.company.Homework08_01_2024;

import main.java.ru.sber.school.reflection.proxy.Cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceProxy implements java.lang.reflect.InvocationHandler {

    private final Object delegate;

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        final var start = System.currentTimeMillis();
        final var result = invoke(method, args);
        final var elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Время работы метода " + method.getName() + ": " + elapsedTime + " (в наносек)");

        return result;
    }

    private Object invoke(Method method, Object[] args) throws Throwable {
        try{
            return method.invoke(delegate, args);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
