package Homework_05_02_2024;

import Homework_29_01_2024.ThreadPool;

public interface ThreadPoolFactory {
    ThreadPool createThreadPool(int corePoolSize, int maximumPoolSize, int taskQueueSize);
}
