package populationRegistry.registryApplication.models;

import java.time.LocalDate;

/**
 * RegistryPersonalData
 */
public class RegistryPersonalData {

    public String firstname = "";
    public String surname = "";
    public String pesel = "";
    public LocalDate dateOfBirth = LocalDate.of(1970, 01, 01);
}