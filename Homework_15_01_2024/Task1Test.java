package Homework_15_01_2024;

import Homework_15_01_2024.Task1.Main;
import Homework_15_01_2024.Task1.PluginManager;
import Homework_15_01_2024.Task1.Plugins.Plugin;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class Task1Test {

    @Test
    public void testPlugin() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        PluginManager pluginLoader = new PluginManager(Main.class.getClassLoader());

        //Загружаем первый плагин
        System.out.println("Загружаем первый плагин");
        Plugin first = pluginLoader.loadPlugin("SimplePlugin", "C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_15_01_2024/Task1/Plugins/SimplePlugin.jar", "Homework_15_01_2024.Task1.Plugins.SimplePlugin");
        System.out.println("Первый плагин загружен\n");

        //Закидываем его в мапу
        Map<String, Class> loadedPlugins = pluginLoader.getLoadedPlugins();

        //Загружаем второй плагин с таким же именем
        System.out.println("Загружаем второй плагин");
        Plugin second = pluginLoader.loadPlugin("SimplePlugin", "C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_15_01_2024/Task1/Plugins/SimplePlugin2.jar", "Homework_15_01_2024.Task1.Plugins2.SimplePlugin");
        System.out.println("Второй плагин загружен\n");

        //Закидываем и его в мапу
        loadedPlugins = pluginLoader.getLoadedPlugins();

        //Вызываем методы плагинов
        //Вызываем метод плагина
        System.out.println("Вызываем методы плагинов: ");
        first.invoke();
        System.out.println("__________\n");

        second.invoke();
        System.out.println("__________\n");

        //Показываем инфу о загруженных плагинах
        System.out.println("Информация о загруженных плагинах: \n");
        for (Map.Entry<String, Class> entry : loadedPlugins.entrySet()) {
            String pluginName = entry.getKey();
            Class pluginClass = entry.getValue();

            System.out.println(pluginName);
            System.out.println(pluginClass);
            System.out.println("__________\n");
        }
    }
}
