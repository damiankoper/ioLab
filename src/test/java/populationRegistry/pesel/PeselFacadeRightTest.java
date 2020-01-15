package populationRegistry.pesel;

//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * Unit test for simple App.
 */
@RunWith(Parameterized.class)
@Category(Pesel.class)
public class PeselFacadeRightTest {

  @Parameter
  public String rightPesel;

  @Parameters
  public static Collection<Object[]> data() {
    Object[][] rightPesels = new Object[][] { { "72121532878" }, { "73071035455" }, { "97021175745" },
        { "70051694215" } };
    return Arrays.asList(rightPesels);
  }

  PeselFacade facade;

  @Before
  public void setUp() {
    facade = new PeselFacade();
  }

  @Test
  public void shouldValidateRightChecksum() {
    // Given
    RegistryApplicationDTO dto = new RegistryApplicationDTO();
    dto.pesel = rightPesel;

    // When
    boolean result = facade.isValid(dto);

    // Then
    assertTrue(result);
  }
}
