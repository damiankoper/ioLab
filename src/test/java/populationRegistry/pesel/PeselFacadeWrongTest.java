package populationRegistry.pesel;

import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

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
@Category(Pesel.class)
@RunWith(Parameterized.class)
public class PeselFacadeWrongTest {

  @Parameter
  public String wrongPesel;

  @Parameters
  public static Collection<Object[]> data() {
    Object[][] wrongPesels = new Object[][] { { "72125532878" }, { "12341035455" }, { "97021125745" },
        { "70051894215" } };
    return Arrays.asList(wrongPesels);
  }

  PeselFacade facade;

  @Before
  public void setUp() {
    facade = new PeselFacade();
  }

  @Test()
  public void shouldValidateWrongChecksum() {
    // Given
    RegistryApplicationDTO dto = new RegistryApplicationDTO();
    dto.pesel = wrongPesel;

    // When
    boolean result = facade.isValid(dto);

    // Then
    assertFalse(result);
  }
}
