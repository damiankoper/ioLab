package populationRegistry.registryApplication.repositories;

import java.util.LinkedList;
import java.util.List;

import populationRegistry.registryApplication.models.Registration;

/**
 * RegistryApplicationRepository
 */
public class RegistrationRepository implements IRepository<Registration> {

    private LinkedList<Registration> container = new LinkedList<>();

    @Override
    public List<Registration> findAll() {
        return container;
    }

    @Override
    public Registration findById(int id) {
        return container.stream().filter(o -> o.id == id).findAny().orElse(null);
    }

    @Override
    public Registration save(Registration object) {
        if (!container.contains(object)) {
            container.add(object);
        }
        return object;
    }

}