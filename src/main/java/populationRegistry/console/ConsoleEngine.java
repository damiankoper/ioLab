package populationRegistry.console;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import populationRegistry.App;

/**
 * ConsoleEngine
 */
public class ConsoleEngine {

  private LinkedList<IController> controllers = new LinkedList<>();

  public void run() {
    boolean exit = false;
    int input = 0;
    while (!exit) {
      displayMenu();
      input = App.scanner.nextInt();
      if (input == 0) {
        exit = true;
      } else {
        dispatchCommand(input);
      }
    }
  }

  public void registerController(IController controller) {
    controllers.add(controller);
  }

  private void dispatchCommand(int number) {
    int commands = 1;
    for (IController iController : controllers) {
      int commandCount = iController.getMenu().size();
      if (number <= commandCount - commands + 1) {
        try {
          Method method = iController.getClass()
              .getMethod(iController.getMenu().keySet().toArray()[number - commands].toString());
          method.invoke(iController);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
            | NoSuchMethodException e) {
          e.printStackTrace();
        }
        return;
      }
      commands += commandCount;
    }
  }

  private void displayMenu() {
    int option = 1;
    System.out.println("\n### Menu:");
    System.out.println("[0] Wyjscie");
    for (IController iController : controllers) {
      System.out.println("--- " + iController.getName());
      for (String name : iController.getMenu().keySet()) {
        System.out.println("[" + String.valueOf(option) + "] " + iController.getMenu().get(name));
        option = option + 1;
      }
    }
  }
}