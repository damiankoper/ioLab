package populationRegistry.registryApplication.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import populationRegistry.console.IController;
import populationRegistry.registryApplication.views.RegistryApplicationShowView;

/**
 * RegistryApplicationController
 */
public class RegistryApplicationController implements IController {

  @Override
  public Map<String, String> getMenu() {
    Map<String, String> menu = new LinkedHashMap<>();
    menu.put("index", "Wyświetl wnioski");
    menu.put("show", "Wyświetl dane wniosku");
    menu.put("update", "Edytuj wniosek");
    return menu;
  }

  @Override
  public String getName() {
    return "Wnioski meldunkowe";
  }

  public void index() {
    
    
    
    System.out.println("index");
  }
  
  public void show() {
    RegistryApplicationShowView view = new RegistryApplicationShowView();
    int id = view.getApplicationId();
    
    
    System.out.println("show");
  }

  public void update() {
    System.out.println("update");
  }

}