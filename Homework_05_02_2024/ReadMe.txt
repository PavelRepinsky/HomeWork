Задание состоит в том, чтобы применить один из GoF-паттернов на одной из уже сделанных домашних работ.
В качестве подопытного была взята программа ScalableThreadPool из домашнего задания за 29_01_2024.
В качестве паттерна проектирования была выбрана абстрактная фабрика. Абстрактная фабрика это порождающий шаблон.

Пример домашней работы до применения шаблона: https://github.com/PavelRepinsky/HomeWork/blob/main/Homework_29_01_2024/ScalableThreadPool.java

В репозитории:
ThreadPoolFactory - интерфейс, предоставляемый для создания семейств взаимосвязанных или взаимозависимых объектов.
ConcreteThreadPoolFactory - имплементирует интерфейс ThreadPoolFactory.
Main - служит, чтобы показать, чтобы все работает.