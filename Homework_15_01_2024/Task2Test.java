package Homework_15_01_2024;

import Homework_15_01_2024.Task2.EncryptedClassLoader;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Task2Test {

    @Test
    public void test2Task() {
            // Определяем ключ и директорию
            String key = "mySecretKey";
            Path dir = Paths.get("C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_15_01_2024/EncryptedClasses");

            // Создаем инстанс нашего лоадера
            EncryptedClassLoader encryptedClassLoader = new EncryptedClassLoader(key, dir, ClassLoader.getSystemClassLoader());

            // Загружаем класс
            try {
                Class<?> loadedClass = encryptedClassLoader.loadClass("Homework_15_01_2024.Task2.EncryptedClasses.EncryptedClass");

                System.out.println("Class loaded successfully: " + loadedClass.getName());
            } catch (ClassNotFoundException e) {
                System.out.println("Failed to load class: " + e.getMessage());
            }
    }
}