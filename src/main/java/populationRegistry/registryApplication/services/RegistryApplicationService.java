package populationRegistry.registryApplication.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import populationRegistry.App;
import populationRegistry.registryApplication.models.RegistryAddressData;
import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.models.RegistryPersonalData;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;
import populationRegistry.registryApplication.services.dto.FilterDataDTO;
import populationRegistry.registryApplication.services.dto.RegistryApplicationDTO;
import populationRegistry.registryApplication.views.dto.TableDTO;

/**
 * RegistryApplicationService
 */
public class RegistryApplicationService {

    public List<RegistryApplication> findAll() {
        RegistryApplicationRepository repository = (RegistryApplicationRepository) App
                .resolve(RegistryApplicationRepository.class);
        return repository.findAll();
    }

    public RegistryApplication findById(int id) {
        RegistryApplicationRepository repository = (RegistryApplicationRepository) App
                .resolve(RegistryApplicationRepository.class);
        return repository.findById(id);
    }

    public List<RegistryApplication> filter(List<RegistryApplication> list, FilterDataDTO filterData) {
        List<RegistryApplication> result;
        if (filterData.filter) {
            result = new LinkedList<RegistryApplication>();
            for (RegistryApplication registryApplication : list) {
                boolean filtered = isFiltered(registryApplication, filterData);
                if (!filtered) {
                    result.add(registryApplication);
                }
            }
        } else {
            result = new LinkedList<RegistryApplication>(list);
        }
        return result;
    }

    private boolean isFiltered(RegistryApplication registryApplication, FilterDataDTO filterData) {
        if (filterData.names.stream().anyMatch(name -> {
            return registryApplication.getPersonalData().firstname.toLowerCase() == name.toLowerCase()
                    || registryApplication.getPersonalData().surname.toLowerCase() == name.toLowerCase();
        })) {
            return false;
        }
        if (filterData.pesels.stream().anyMatch(pesel -> {
            return registryApplication.getPersonalData().pesel.toLowerCase() == pesel.toLowerCase();
        })) {
            return false;
        }
        return true;
    }

    public RegistryApplication update(RegistryApplication registryApplication, RegistryApplicationDTO dto) {
        RegistryPersonalData personal = registryApplication.getPersonalData();
        RegistryAddressData address = registryApplication.getAddressData();

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

        registryApplication.status = RegistryApplication.Status.valueOfLabel(dto.status);

        RegistryApplicationRepository repository = (RegistryApplicationRepository) App
                .resolve(RegistryApplicationRepository.class);
        return repository.save(registryApplication);
    }

    public RegistryApplicationDTO prepareDTO(RegistryApplication registryApplication) {
        RegistryPersonalData personal = registryApplication.getPersonalData();
        RegistryAddressData address = registryApplication.getAddressData();

        RegistryApplicationDTO dto = new RegistryApplicationDTO();
        dto.id = registryApplication.id;
        dto.firstname = personal.firstname;
        dto.surname = personal.surname;
        dto.pesel = personal.pesel;
        dto.dateOfBirth = personal.dateOfBirth.toString();
        dto.apartmentNumber = address.apartmentNumber;
        dto.houseNumber = address.houseNumber;
        dto.city = address.city;
        dto.country = address.country;
        dto.street = address.street;
        dto.status = registryApplication.status.toString();
        dto.zipCode = address.zipCode;

        return dto;
    }

    public TableDTO prepareTableDTO(List<RegistryApplication> list) {
        TableDTO dto = new TableDTO();
        dto.header = new LinkedList<String>(
                Arrays.asList("Id", "Imie", "Nazwisko", "PESEL", "Wnioskowany adres zameldowania"));
        LinkedList<String> format = new LinkedList<String>(Arrays.asList("%5s", "%15s", "%15s", "%11s", "%60s"));
        dto.headerFormat = format;
        dto.bodyFormat = format;
        for (RegistryApplication registryApplication : list) {
            LinkedList<String> row = new LinkedList<>();
            row.add(String.valueOf(registryApplication.id));

            RegistryPersonalData personal = registryApplication.getPersonalData();
            row.add(personal.firstname);
            row.add(personal.surname);
            row.add(personal.pesel);

            RegistryAddressData address = registryApplication.getAddressData();
            row.add(address.city + " ul." + address.street + " " + address.houseNumber + "/" + address.apartmentNumber
                    + " " + address.zipCode + ", " + address.country);
            dto.body.add(row);
        }
        return dto;
    }
}