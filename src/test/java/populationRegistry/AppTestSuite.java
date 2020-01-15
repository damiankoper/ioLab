package populationRegistry;

import org.junit.experimental.categories.Categories;
//import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

//import populationRegistry.pesel.Pesel;
import populationRegistry.pesel.PeselFacadeRightTest;
import populationRegistry.pesel.PeselFacadeTest;
import populationRegistry.pesel.PeselFacadeWrongTest;
import populationRegistry.registryApplication.controllers.RegistryApplicationControllerTest;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepositoryTest;
import populationRegistry.registryApplication.services.RegistryApplicationServiceTest;

/**
 * AppTestSuite
 */
@SuiteClasses({ AppTest.class, RegistryApplicationControllerTest.class, RegistryApplicationRepositoryTest.class,
        RegistryApplicationServiceTest.class, PeselFacadeRightTest.class, PeselFacadeWrongTest.class,
        PeselFacadeTest.class })
@RunWith(Categories.class)

public class AppTestSuite {

}