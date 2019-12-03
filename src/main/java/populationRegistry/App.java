package populationRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import populationRegistry.console.ConsoleEngine;
import populationRegistry.registryApplication.controllers.RegistryApplicationController;

public class App {

    private static HashMap<Class, Object> providers = new HashMap<Class, Object>();

    public static void main(String[] args) {

        ConsoleEngine engine = new ConsoleEngine();
        engine.registerController(new RegistryApplicationController());
        engine.run();
    }

    public static Object resolve(Class provider) {
        return App.providers.get(provider);
    }

    public static void registerProvider(Object provider) {
        App.providers.put(provider.getClass(), provider);
    }
}
