package Homework_15_01_2024.Task1;

import Homework_15_01_2024.Task1.Plugins.Plugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class PluginManager {
    private Map<String, Class> loadedPlugins = new HashMap<>();
    private ClassLoader parentClassLoader;

    public PluginManager(ClassLoader parentClassLoader) {
        this.parentClassLoader = parentClassLoader;
    }

    public Plugin loadPlugin(String pluginName, String jarFilePath, String className) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        File file = new File(jarFilePath);
        URL url = file.toURI().toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url}, parentClassLoader);
        Class<?> pluginClass = urlClassLoader.loadClass(className);

        // Если плагин с таким именем уже загружен
        if (loadedPlugins.containsKey(pluginName)) {
            System.out.println("A plugin with the same name is already loaded. Using a separate class loader for the new plugin...");
            urlClassLoader.close(); // Закрываем предыдущий лоадер
            urlClassLoader = new URLClassLoader(new URL[]{url}); // Создаем новый
        }

        if (loadedPlugins.containsKey(pluginName)) {
        loadedPlugins.put("Another " + pluginName, pluginClass);
        }
        else {loadedPlugins.put(pluginName, pluginClass);}

        return (Plugin) pluginClass.newInstance();
    }

    public Map<String, Class> getLoadedPlugins() {
        return loadedPlugins;
    }
}