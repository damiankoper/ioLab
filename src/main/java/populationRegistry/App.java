package populationRegistry;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import populationRegistry.console.ConsoleEngine;
import populationRegistry.pesel.PeselFacade;
import populationRegistry.registryApplication.controllers.RegistryApplicationController;
import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistrationRepository;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;
import populationRegistry.registryApplication.services.IPeselFacade;
import populationRegistry.registryApplication.services.RegistrationService;
import populationRegistry.registryApplication.services.RegistryApplicationService;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    private static HashMap<Class<? extends Object>, Object> providers = new HashMap<Class<? extends Object>, Object>();

    public static void main(String[] args) {
        RegistryApplicationRepository registryApplicationRepository = new RegistryApplicationRepository();

        /**
         * Data seed
         */
        RegistryApplication registryApplication = new RegistryApplication();
        registryApplication.getPersonalData().dateOfBirth = LocalDate.of(1990, 01, 01);
        registryApplication.getPersonalData().firstname = "Damian";
        registryApplication.getPersonalData().surname = "Koper";
        registryApplication.getPersonalData().pesel = "72060319389";
        registryApplication.getAddressData().apartmentNumber = "20";
        registryApplication.getAddressData().houseNumber = "10";
        registryApplication.getAddressData().street = "Marszalkowska";
        registryApplication.getAddressData().zipCode = "00-043";
        registryApplication.getAddressData().country = "Polska";
        registryApplication.getAddressData().city = "Warszawa";
        registryApplicationRepository.save(registryApplication);

        App.registerProvider(new RegistryApplicationService());
        App.registerProvider(registryApplicationRepository);
        App.registerProvider(new RegistrationService());
        App.registerProvider(new RegistrationRepository());
        App.registerProvider(new PeselFacade());

        ConsoleEngine engine = new ConsoleEngine();
        engine.registerController(new RegistryApplicationController());
        engine.run();
    }

    public static Object resolve(Class<? extends Object> provider) {
        return App.providers.get(provider);
    }

    public static void registerProvider(Object provider) {
        App.providers.put(provider.getClass(), provider);
    }
}
