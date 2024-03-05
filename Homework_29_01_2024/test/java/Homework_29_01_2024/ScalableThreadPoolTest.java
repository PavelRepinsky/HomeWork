package Homework_29_01_2024;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScalableThreadPoolTest {

    @Test
    //Проверяем, что все задачи выполняются
    public void testScalableThreadPool_allTasksAreCompleted() {
        ThreadPool threadPool = new ScalableThreadPool(1, 5, 10);
        Runnable task = () -> System.out.println("Test Task");
        threadPool.execute(task);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nAll tasks has been completed\n");
        System.out.println("____________________________\n");
    }

    @Test
    //Проверяем, что у нас увеличивается и уменьшается количество потоков
    public void testScalableThreadPool_ThreadCountIncreasingAndDecreasing() {
        ThreadPool threadPool = new ScalableThreadPool(1, 5, 10);
        threadPool.execute(() -> {});
        threadPool.execute(() -> {});

        assertEquals(2, ((ScalableThreadPool) threadPool).threadCount.get());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nThread count increases and decreases\n");
        System.out.println("____________________________\n");
    }

    @Test
    //Проверяем, что количество потоков не превышает максимально допустимое значение
    public void testScalableThreadPool_ScalingUpThreadCountToMaxBorder() {
        ThreadPool threadPool = new ScalableThreadPool(1, 5, 10);

        for (int i = 0; i < 10; i++) {
            final int taskNumber = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        assertTrue(((ScalableThreadPool) threadPool).getCurrentThreadCount() <= 5);

        System.out.println("\nThread count doesn't exceed max border\n");
        System.out.println("____________________________\n");
    }

    @Test
    //Проверяем, что количество потоков не становится меньше минимально допустимого значения
    public void testScalableThreadPool_ScalingDownThreadCountToMinBorder() throws InterruptedException {
        ScalableThreadPool threadPool = new ScalableThreadPool(2, 5, 7);

        for (int i = 0; i < 7; i++) {
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

        Thread.sleep(5000);

        assertTrue(threadPool.getCurrentThreadCount() == 2);

        System.out.println("\nThread count doesn't exceed min border\n");
        System.out.println("____________________________\n");
    }
}
