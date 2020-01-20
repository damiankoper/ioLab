package fitnesse.fixtures;


import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;

public class RegistryApplicationRepositoryFixture {
    private String country;

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isTheSame() {

        var application = new RegistryApplication();
        application.getAddressData().country = country;

        var repository = new RegistryApplicationRepository();
        repository.save(application);

        var checkApplication = repository.findById(1);

        return checkApplication.getAddressData()==application.getAddressData();   
    }
}