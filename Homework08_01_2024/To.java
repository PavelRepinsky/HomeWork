package com.company.Homework08_01_2024;

public class To {

    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public int age;

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale;

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return "To{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }

}
