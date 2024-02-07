package Homework_15_01_2024.Task3;

import Homework_15_01_2024.Task3.Plugins.RPSPlugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        // Загружаем плагины из директории
        List<RPSPlugin> plugins = loadPlugins("C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_15_01_2024/Task3/Plugins/");

        // Начинается мясорубка
        playGame(plugins);
    }

    // Загружаем плагины
    private static List<RPSPlugin> loadPlugins(String directory) {
        List<RPSPlugin> plugins = new ArrayList<>();
        File pluginDir = new File(directory);

        if (pluginDir.exists() && pluginDir.isDirectory()) {
            File[] files = pluginDir.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(".jar")) {
                    try {
                        URL url = file.toURI().toURL();
                        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
                        Class<?> pluginClass = classLoader.loadClass("Homework_15_01_2024.Task3.Plugins." + removeFileExtension(file.getName(), true));
                        RPSPlugin plugin = (RPSPlugin) pluginClass.newInstance();
                        plugins.add(plugin);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return plugins;
    }

    // Под капотом мясорубки
    private static void playGame(List<RPSPlugin> plugins) {

        System.out.println("Starting a game...");
        Random random = new Random();

        while (plugins.size() > 1) {
            // Берём два рандомных плагина
            int index1 = random.nextInt(plugins.size());
            int index2 = random.nextInt(plugins.size());
            while (index1 == index2) {
                index2 = random.nextInt(plugins.size());
            }
            RPSPlugin plugin1 = plugins.get(index1);
            RPSPlugin plugin2 = plugins.get(index2);

            // Узнаем ход каждого плагина
            String move1 = plugin1.getMove();
            String move2 = plugin2.getMove();

            // Сравниваем ходы плагинов и определяем победителя
            if (move1.equals("Rock") && move2.equals("Scissors") ||
                    move1.equals("Paper") && move2.equals("Rock") ||
                    move1.equals("Scissors") && move2.equals("Paper")) {
                System.out.println(plugin1.getClass().getName() + " wins against " + plugin2.getClass().getName());
                plugins.remove(index2);
            } else if (move2.equals("Rock") && move1.equals("Scissors") ||
                    move2.equals("Paper") && move1.equals("Rock") ||
                    move2.equals("Scissors") && move1.equals("Paper")) {
                System.out.println(plugin2.getClass().getName() + " wins against " + plugin1.getClass().getName());
                plugins.remove(index1);
            } else {
                System.out.println("Its a tie! (" + plugin1 + " vs " + plugin2 + ")");
            }
        }

        // Последний выживший в мясорубке является победителем
        System.out.println("The winner is: " + plugins.get(0));
    }

    // метод removeFileExtension убирает из названия файла расширение, чтобы класслоадер смог загрузить все классы
    public static String removeFileExtension(String filename, boolean removeAllExtensions) {
        if (filename == null || filename.isEmpty()) {
            return filename;
        }

        String extPattern = "(?<!^)[.]" + (removeAllExtensions ? ".*" : "[^.]*$");
        return filename.replaceAll(extPattern, "");
    }
}