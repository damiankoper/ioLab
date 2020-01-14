package populationRegistry;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import populationRegistry.pesel.Pesel;

/**
 * AppTestSuite
 */
@SuiteClasses(AppTestSuite.class)
@IncludeCategory(Pesel.class)
@RunWith(Categories.class)

public class PeselTestSuite {

}