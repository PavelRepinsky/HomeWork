package Homework_15_01_2024.Task1.Plugins;

public class SimplePlugin implements Plugin{
    @Override
    public void invoke() {
        System.out.println("First plugin");
    }
}
