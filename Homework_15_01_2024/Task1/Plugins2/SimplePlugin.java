package Homework_15_01_2024.Task1.Plugins2;

import Homework_15_01_2024.Task1.Plugins.Plugin;

public class SimplePlugin implements Plugin {
    @Override
    public void invoke() {
        System.out.println("Second plugin");
    }
}
