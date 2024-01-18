package com.company.Homework08_01_2024;

import java.lang.reflect.Method;

public class BeanUtils {

    /**
     * Scans object "from" for all getters. If object "to"
     * <p>
     * contains correspondent setter, it will invoke it
     * <p>
     * to set property value for "to" which equals to the property
     * <p>
     * of "from".
     * <p>
     * <p/>
     * <p>
     * The type in setter should be compatible to the value returned
     * <p>
     * by getter (if not, no invocation performed).
     * <p>
     * Compatible means that parameter type in setter should
     * <p>
     * be the same or be superclass of the return type of the getter.
     * <p>
     * <p/>
     * <p>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */


    public static void assign(Object to, Object from) {
        Class<?> fromClass = from.getClass();
        Class<?> toClass = to.getClass();

        Method[] fromMethods = fromClass.getMethods();
        for (Method fromMethod : fromMethods) {
            if (fromMethod.getName().startsWith("get")) {
                String propertyName = fromMethod.getName().substring(3);
                String setterName = "set" + propertyName;

                try{
                    Method toSetter = toClass.getMethod(setterName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(from);
                    toSetter.invoke(to, value);
                }
                catch (Exception e) {}
            }
            else if (fromMethod.getName().startsWith("is")) {
                String propertyName = fromMethod.getName().substring(2);
                String setterName = "set" + propertyName;
                try{
                    Method toSetter = toClass.getMethod(setterName, fromMethod.getReturnType());
                    Object value = fromMethod.invoke(from);
                    toSetter.invoke(to, value);
                }
                catch (Exception e) {}
            }
        }
    }

    public static void main(String[] args) {
        From from = new From("Tolik", 15, true);
        To to = new To();

        assign(to, from);

        System.out.println(to.toString());
    }
}