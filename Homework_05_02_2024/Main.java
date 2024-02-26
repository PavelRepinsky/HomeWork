package Homework_05_02_2024;

import Homework_29_01_2024.ThreadPool;

public class Main {
    public static void main(String[] args) {
        // Создаем инстанс ConcreteThreadPoolFactory
        ThreadPoolFactory factory = new ConcreteThreadPoolFactory();

        // Используем фабрику для создания инстанса ScalableThreadPool
        ThreadPool threadPool = factory.createThreadPool(1, 5, 10);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskNumber + " is being executed by Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
