package populationRegistry.registryApplication.controllers;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertSame;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
//import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.FullVerifications;
//import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import populationRegistry.App;
import populationRegistry.registryApplication.models.RegistryApplication;
//import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;
import populationRegistry.registryApplication.services.RegistryApplicationService;
import populationRegistry.registryApplication.services.dto.FilterDataDTO;
//import populationRegistry.registryApplication.views.RegistryApplicationIndexView;
import populationRegistry.registryApplication.views.dto.TableDTO;

/**
 * RegistryApplicationServiceTest
 */
@Category(Controllers.class)
public class RegistryApplicationControllerTest {

    @Tested
    public RegistryApplicationController controller;
    @Mocked
    public RegistryApplicationService service;

    @Before
    public void setup() {
        controller = new RegistryApplicationController();
        App.registerProvider(new RegistryApplicationService());
    }

    @Test
    public void shouldIndex() {
        // Given
        var list = new LinkedList<RegistryApplication>();
        var tableDTO = new TableDTO();
        App.scanner = new Scanner(new ByteArrayInputStream("n".getBytes()));
        new Expectations() {
            {
                service.findAll();
                result = list;
                service.filter((LinkedList<RegistryApplication>) any, (FilterDataDTO) any);
                result = list;
                service.prepareTableDTO((LinkedList<RegistryApplication>) any);
                result = tableDTO;
            }
        };
        // When
        controller.index();

        // Then
        new FullVerifications() {
            {
                service.findAll();
                service.filter((LinkedList<RegistryApplication>) any, (FilterDataDTO) any);
                service.prepareTableDTO((LinkedList<RegistryApplication>) any);
            }
        };
    }
}