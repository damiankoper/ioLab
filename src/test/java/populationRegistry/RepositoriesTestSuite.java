package populationRegistry;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import populationRegistry.registryApplication.repositories.Repositories;
//import populationRegistry.registryApplication.services.Services;

/**
 * AppTestSuite
 */
@SuiteClasses(AppTestSuite.class)
@IncludeCategory(Repositories.class)
@RunWith(Categories.class)
public class RepositoriesTestSuite {

}