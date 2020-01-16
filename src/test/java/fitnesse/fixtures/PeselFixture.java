package fitnesse.fixtures;

import populationRegistry.pesel.PeselFacade;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

public class PeselFixture {
    private String pesel;

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean isValid() {
        var dto = new RegistryApplicationDTO();
        dto.pesel = pesel;
        return new PeselFacade().isValid(dto);
    }
}