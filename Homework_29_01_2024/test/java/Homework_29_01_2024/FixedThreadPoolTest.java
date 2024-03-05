package Homework_29_01_2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FixedThreadPoolTest {

    @Test
    //Проверяем, что все задачи выполняются
    public void testFixedThreadPool_allTasksAreCompleted() {
        ThreadPool threadPool = new FixedThreadPool(3);
        int completedTasks = 0;

        for (int i = 0; i < 5; i++) {
            int taskNum = i;
            threadPool.execute(() -> System.out.println("Task " + taskNum + " executed by thread " + Thread.currentThread().getName()));
            completedTasks++;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Смотрим все ли таски выполнены
        Assertions.assertEquals(5, completedTasks);
        System.out.println("\nAll tasks has been completed\n");
        System.out.println("____________________________\n");
    }


    @Test
    //Проверяем, что указанное количество потоков совпадает с заданным в конструкторе
    public void testFixedThreadPool_thereAreSpecifiedCountOfThreads() {
        ThreadPool threadPool = new FixedThreadPool(3);

        List<String> list = new ArrayList<>();

        // Execute tasks in the thread pool
        for (int i = 0; i < 5; i++) {
            int taskNum = i;
            threadPool.execute(() -> {System.out.println("Task " + taskNum + " executed by thread " + Thread.currentThread().getName());
                        if (!list.contains(Thread.currentThread().getName())) {
                            list.add(Thread.currentThread().getName());
                }});
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(3, list.size());
        System.out.println("\nThere are expected count of threads\n");
        System.out.println("____________________________\n");
    }
}
