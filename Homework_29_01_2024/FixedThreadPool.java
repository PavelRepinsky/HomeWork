package Homework_29_01_2024;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    public final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public FixedThreadPool(int numberOfThreads) {
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = queue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            thread.start();
        }
    }

    @Override
    public void start() {
        // Запуск потоков происходит в конструкторе
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new FixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            int taskNum = i;
            threadPool.execute(() -> System.out.println("Task " + taskNum + " executed by thread " + Thread.currentThread().getName()));
            }
        }
    }