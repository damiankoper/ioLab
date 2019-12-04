package populationRegistry.registryApplication.repositories;

import java.util.List;

/**
 * IRepository
 */
public interface IRepository<T> {

    public List<T> findAll();

    public T findById(int id);

    public T save(T object);
}