package populationRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Class app = App.class;
        try {
            App a = (App) app.getConstructors()[0].newInstance();
            a.xd();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | SecurityException e) {
            e.printStackTrace();
        }
    }
    public void xd(){
        System.out.println( "Hello World!" );

    }
}
