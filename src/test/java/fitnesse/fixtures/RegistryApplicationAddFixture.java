package fitnesse.fixtures;

import populationRegistry.registryApplication.models.RegistryApplication;
import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;

public class RegistryApplicationAddFixture {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public int howMany() {

        var repository = new RegistryApplicationRepository();

        for (int i = 0; i < number; i++) {
            var application = new RegistryApplication();
            repository.save(application);
        }

        var list = repository.findAll();

        return list.size();
    }
}