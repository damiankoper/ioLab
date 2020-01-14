package populationRegistry.registryApplication.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import mockit.Expectations;
import mockit.FullVerifications;
import mockit.Mocked;
import mockit.Tested;
import populationRegistry.App;
import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * RegistryApplicationServiceTest
 */
@Category(Services.class)
public class RegistryApplicationServiceTest {

  @Tested
  public RegistryApplicationService service;

  @Mocked
  public RegistryApplicationRepository repository;

  @Before
  public void setup() {
    service = new RegistryApplicationService();
    App.registerProvider(new RegistryApplicationRepository());
  }

  @Test
  public void shouldFindAll() {
    // Given
    new Expectations() {
      {
        repository.findAll();
        result = new LinkedList<RegistryApplication>();
      }
    };
    // When
    repository.findAll();

    // Then
    new FullVerifications() {
      {
        repository.findAll();
      }
    };
  }

  @Test
  public void shouldFindById() {
    // Given
    new Expectations() {
      {
        repository.findById(10);
        result = new RegistryApplication();
      }
    };
    // When
    repository.findById(10);

    // Then
    new FullVerifications() {
      {
        repository.findById(anyInt);
      }
    };
  }

  @Test
  public void shouldUpdateModel() {

    // Given
    var dto = new RegistryApplicationDTO();
    dto.city = "Wroclaw";
    dto.dateOfBirth = "1998-01-01";

    var registryApplication = new RegistryApplication();
    registryApplication.id = 1;

    new Expectations() {
      {
        repository.save(registryApplication);
        result = registryApplication;
      }
    };
    // When
    var result = service.update(registryApplication, dto);

    // Then
    assertSame(registryApplication, result);
    assertEquals(registryApplication.getAddressData().city, dto.city);
    new FullVerifications() {
      {
        repository.save(registryApplication);
      }
    };

  }
}