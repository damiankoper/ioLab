package populationRegistry.registryApplication.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;

/**
 * Unit test for simple App.
 */
@Category(Repositories.class)
public class RegistryApplicationRepositoryTest {
  RegistryApplicationRepository repository;
  RegistryApplication application;

  @Before
  public void setUp() {
    repository = new RegistryApplicationRepository();
    application = new RegistryApplication();
  }

  @Test
  public void shouldBeEmptyAtInit() {
    // Given

    // When
    var list = repository.findAll();

    // Then
    assertEquals(0, list.size());
  }

  @Test
  public void shouldNotBeEmpty() {
    // Given
    repository.save(application);

    // When
    var list = repository.findAll();

    // Then
    assertNotEquals(0, list.size());
  }

  @Test
  public void findMyApplication() {
    // Given
    repository.save(application);

    // When
    var app = repository.findById(1);

    // Then
    assertEquals(application.id, app.id);
  }
}