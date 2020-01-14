package populationRegistry;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import populationRegistry.registryApplication.services.Services;

/**
 * AppTestSuite
 */
@SuiteClasses(AppTestSuite.class)
@IncludeCategory(Services.class)
@RunWith(Categories.class)

public class ServicesTestSuite {

}