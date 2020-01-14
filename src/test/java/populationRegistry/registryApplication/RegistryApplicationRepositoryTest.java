package populationRegistry.registryApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import populationRegistry.registryApplication.repositories.RegistryApplicationRepository;

/**
 * Unit test for simple App.
 */
public class RegistryApplicationRepositoryTest
{
    RegistryApplicationRepository repository;
    
    @Before
    public void setUp(){
      repository = new RegistryApplicationRepository();
    }

    @Test

    public void shouldBeEmptyAtInit(){

        //Given

        //When
        var list = repository.findAll();
        
        //Then
        assertEquals(0, list.size());

    }


    
    
}