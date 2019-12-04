package populationRegistry.registryApplication.repositories;

import java.util.LinkedList;
import java.util.List;

import populationRegistry.registryApplication.models.RegistryApplication;

/**
 * RegistryApplicationRepository
 */
public class RegistryApplicationRepository implements IRepository<RegistryApplication> {

    private int nextId = 1;
    private LinkedList<RegistryApplication> container = new LinkedList<>();

    @Override
    public List<RegistryApplication> findAll() {
        return container;
    }

    @Override
    public RegistryApplication findById(int id) {
        return container.stream().filter(o -> o.id == id).findAny().orElse(null);
    }

    @Override
    public RegistryApplication save(RegistryApplication object) {
        if (!container.contains(object)) {
            container.add(object);
            object.id = nextId++;
        }
        return object;
    }

}