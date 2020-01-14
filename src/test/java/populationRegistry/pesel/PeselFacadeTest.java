package populationRegistry.pesel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * Unit test for simple App.
 */
public class PeselFacadeTest {
  PeselFacade facade;

  @Before
  public void setUp() {
    facade = new PeselFacade();
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowExceptionWhenNotFilledWithValues() {
    // Given
    RegistryApplicationDTO dto = new RegistryApplicationDTO();

    // When
    facade.isValid(dto);

    // Then exception
  }
}
