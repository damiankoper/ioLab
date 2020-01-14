package populationRegistry.pesel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * Unit test for simple App.
 */
@Category(Pesel.class)
public class PeselFacadeTest {
  PeselFacade facade;

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Before
  public void setUp() {
    facade = new PeselFacade();
  }

  @Test
  public void shouldThrowExceptionWhenNotFilledWithValues() {
    // Given
    RegistryApplicationDTO dto = new RegistryApplicationDTO();

    // Expect
    exception.expect(NullPointerException.class);
    // When
    facade.isValid(dto);

  }
}
