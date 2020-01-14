package populationRegistry.registryApplication.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import populationRegistry.App;
import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * RegistryApplicationServiceTest
 */
public class RegistryApplicationServiceTest {

  @Tested
  public RegistryApplicationService service;

  @Mocked
  public RegistryApplicationRepository repository;

  @Before
  public void setup(){
    service = new RegistryApplicationService();
    App.registerProvider(new RegistryApplicationRepository());
  }

  @Test
  public void shouldUpdateModel() {
  
    // Given
    var dto = new RegistryApplicationDTO();
    dto.city = "Wroclaw";
    
    var registryApplication = new RegistryApplication();
    registryApplication.id = 1;
    
    new Expectations() {{
      repository.save(registryApplication);
    }};
    // When
    var result = service.update(registryApplication, dto);

    // Then
    assertSame(registryApplication, result);
    assertEquals(registryApplication.getAddressData().city, dto.city);
    /* 
    new FullVerifications(){{
      repository.save();
    }}; */
  }
}