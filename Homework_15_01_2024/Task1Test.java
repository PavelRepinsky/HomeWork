package Homework_15_01_2024;

import com.sun.source.util.Plugin;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;

public class Task1Test {
    @Test

    public void testLoadPlugin() {

        String pluginsDirectory = "C:\\Users\\20655284\\IdeaProjects\\SberEducationV2\\src\\main\\java\\Homework_15_01_2024";

        PluginManager pluginManager = new PluginManager(pluginsDirectory);

        Plugin myPlugin = pluginManager.load("SimplePlugin", "SimplePlugin");
        assertNotNull(myPlugin);
    }
}
