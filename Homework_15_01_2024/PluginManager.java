package Homework_15_01_2024;

import com.sun.source.util.Plugin;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PluginManager {
    private final String pluginRootDirectory;
    private Map<String, Plugin> loadedPlugins;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
        this.loadedPlugins = new HashMap<>();
    }

    public Plugin load(String pluginName, String pluginClassName) {
        try {
            URL pluginUrl = new File(pluginRootDirectory).toURI().toURL();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{pluginUrl});

            Class<?> pluginClass = classLoader.loadClass(pluginClassName);
            Plugin plugin = (Plugin) pluginClass.getDeclaredConstructor().newInstance();

            // Если плагин с таким именем уже загружен
            if (loadedPlugins.containsKey(pluginName)) {
                System.out.println("A plugin with the same name is already loaded. Using a separate class loader for the new plugin...");
                classLoader.close(); // Закрываем предыдущий лоадер
                classLoader = new URLClassLoader(new URL[]{pluginUrl}); // Создаем новый
            }
            loadedPlugins.put(pluginName, plugin);
            return plugin;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
