package Homework_29_01_2024;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ScalableThreadPool implements ThreadPool{
    private int corePoolSize;
    private int maximumPoolSize;
    private BlockingQueue<Runnable> taskQueue;
    private AtomicInteger threadCount;

    public ScalableThreadPool(int corePoolSize, int maximumPoolSize, int taskQueueSize) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.taskQueue = new LinkedBlockingQueue<>(taskQueueSize);
        this.threadCount = new AtomicInteger(corePoolSize);
    }

    @Override
    public void start() {
    }

    @Override
    public void execute(Runnable task) {
        taskQueue.offer(task); // Добавляем таску в очередь

        if (threadCount.get() < maximumPoolSize && taskQueue.size() > threadCount.get()) {
            int currentThreadCount = threadCount.incrementAndGet();
            System.out.println("Thread count increased to: " + currentThreadCount);
            new Thread(new Worker()).start();
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                Runnable task = taskQueue.poll();
                if (task != null) {
                    task.run();
                } else {
                    // Если больше нет тасок, то уменьшаем количество потоков
                    int currentThreadCount = threadCount.decrementAndGet();
                    System.out.println("Thread count decreased to: " + currentThreadCount);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
            // Создаем тредпул со следующими параметрами: corePoolSize = 1, maximumPoolSize = 5, taskQueue size = 10
            ThreadPool threadPool = new ScalableThreadPool(1, 5, 10);

            // Submit tasks to the ThreadPool
            for (int i = 0; i < 10; i++) {
                final int taskNumber = i;
                threadPool.execute(() -> {
                    System.out.println("Task " + taskNumber + " is being executed by Thread: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // Типа таска выполняется
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });}
    }
}
