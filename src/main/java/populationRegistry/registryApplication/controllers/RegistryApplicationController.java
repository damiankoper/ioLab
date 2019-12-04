package populationRegistry.registryApplication.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import populationRegistry.App;
import populationRegistry.console.IController;
import populationRegistry.pesel.PeselFacade;
import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.services.RegistrationService;
import populationRegistry.registryApplication.services.RegistryApplicationService;
import populationRegistry.registryApplication.services.dto.FilterDataDTO;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;
import populationRegistry.registryApplication.views.RegistryApplicationIndexView;
import populationRegistry.registryApplication.views.RegistryApplicationShowView;
import populationRegistry.registryApplication.views.RegistryApplicationUpdateView;
import populationRegistry.registryApplication.views.dto.TableDTO;

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
    RegistryApplicationIndexView view = new RegistryApplicationIndexView();
    FilterDataDTO filterDataDTO = view.getFilterData();
    RegistryApplicationService service = (RegistryApplicationService) App.resolve(RegistryApplicationService.class);
    List<RegistryApplication> list = service.findAll();
    list = service.filter(list, filterDataDTO);
    TableDTO tableDTO = service.prepareTableDTO(list);
    view.displayTable(tableDTO);
  }

  public void show() {
    RegistryApplicationShowView view = new RegistryApplicationShowView();
    RegistryApplicationService service = (RegistryApplicationService) App.resolve(RegistryApplicationService.class);
    int id = view.getApplicationId();
    RegistryApplication registryApplication = service.findById(id);

    if (registryApplication == null) {
      view.displayNotFoundError();
    } else {
      RegistryApplicationDTO dto = service.prepareDTO(registryApplication);
      view.displayModel(dto);
    }
  }

  public void update() {
    RegistryApplicationUpdateView view = new RegistryApplicationUpdateView();
    RegistryApplicationService registryApplicationService = (RegistryApplicationService) App
        .resolve(RegistryApplicationService.class);
    RegistrationService registrationService = (RegistrationService) App.resolve(RegistrationService.class);
    int id = view.getApplicationId();
    RegistryApplication registryApplication = registryApplicationService.findById(id);
    if (registryApplication == null) {
      view.displayNotFoundError();
    } else {
      RegistryApplicationDTO dto = registryApplicationService.prepareDTO(registryApplication);
      dto = view.getUpdateData(dto);
      if (!PeselFacade.isValid(dto)) {
        view.displayNotValidError();
      } else {
        registryApplicationService.update(registryApplication, dto);
        if (registryApplication.status.equals(RegistryApplication.Status.Accepted)) {
          registrationService.create(dto);
          view.displayCreatedRegistration();
        }
        view.displaySuccess();
      }
    }
  }
}