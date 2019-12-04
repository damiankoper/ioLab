package populationRegistry.registryApplication.services;

import java.time.LocalDate;

import populationRegistry.App;
import populationRegistry.registryApplication.models.Registration;
import populationRegistry.registryApplication.models.RegistryAddressData;
import populationRegistry.registryApplication.models.RegistryPersonalData;
import populationRegistry.registryApplication.repositories.RegistrationRepository;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;

/**
 * RegistrationService
 */
public class RegistrationService {

    public Registration create(RegistryApplicationDTO dto) {
        Registration registration = new Registration();
        RegistryPersonalData personal = registration.getPersonalData();
        RegistryAddressData address = registration.getAddressData();

        personal.firstname = dto.firstname;
        personal.surname = dto.surname;
        personal.pesel = dto.pesel;
        address.apartmentNumber = dto.apartmentNumber;
        address.city = dto.city;
        address.country = dto.country;
        address.houseNumber = dto.houseNumber;
        address.zipCode = dto.zipCode;
        address.street = dto.street;
        personal.dateOfBirth = LocalDate.parse(dto.dateOfBirth);
        registration.status = Registration.Status.Current;

        RegistrationRepository repository = (RegistrationRepository) App.resolve(RegistrationRepository.class);

        return repository.save(registration);
    }

}