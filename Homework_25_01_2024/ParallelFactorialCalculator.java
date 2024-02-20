package Homework_25_01_2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelFactorialCalculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_25_01_2024/numbers.txt"));

            //Создаем тредпул на 5 тредов (можно больше, если нужно)
            ExecutorService executor = Executors.newFixedThreadPool(5);

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                executor.execute(() -> {
                    long factorial = 1;
                    for (int i = 1; i <= number; i++) {
                        factorial *= i;
                    }
                    System.out.println("Factorial of " + number + " is " + factorial);
                });
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                //Усыпляем ненадолго проверку, чтобы сильно не спамить
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
