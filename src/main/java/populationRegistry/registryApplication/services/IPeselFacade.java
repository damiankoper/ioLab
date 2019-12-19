package populationRegistry.registryApplication.services;

import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * PeselFacade
 */
public interface IPeselFacade {

    public boolean isValid(RegistryApplicationDTO dto);

}