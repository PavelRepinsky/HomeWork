package Homework_05_02_2024;

import Homework_29_01_2024.ScalableThreadPool;
import Homework_29_01_2024.ThreadPool;

public class ConcreteThreadPoolFactory implements ThreadPoolFactory {
    @Override
    public ThreadPool createThreadPool(int corePoolSize, int maximumPoolSize, int taskQueueSize) {
        return new ScalableThreadPool(corePoolSize, maximumPoolSize, taskQueueSize);
    }
}
