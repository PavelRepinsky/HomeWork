package Homework_22_01_2024;

public class Person {

    private String name;
    private int age;

    public Person() {
        String name = null;
        int age = 0;
    }

    public Person (String personName, int personAge) {
        this.name = personName;
        this.age = personAge;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
