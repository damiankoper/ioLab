package populationRegistry.console;

import java.util.LinkedList;

/**
 * ConsoleEngine
 */
public class ConsoleEngine {

  private LinkedList<IController> controllers;

  public void run() {

  }

  public void registerController(IController controller) {
    controllers.add(controller);
  }

  public void dispatchCommand(int number) {

  }

  public void displayMenu() {
    Integer option = 1;
    System.out.println("Menu");
    System.out.println("[0] Wyjście");
    for (IController iController : controllers) {
      System.out.println("---");
      System.out.println("---" + iController.getName());
      for (String name : iController.getMenu().keySet()) {
        System.out.println("[" + String.valueOf(option) + "] " + iController.getMenu().get(name));
        option = option + 1;
      }
    }
  }
}