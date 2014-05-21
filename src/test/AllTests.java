package test;

import junit.framework.JUnit4TestAdapter;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestUserMovie.class,
        TestMovieTest.class
        })
/**
 * This class is a suite of two other test cases
 */
public class AllTests {

    // Used for backward compatibility (IDEs, Ant and JUnit 3 text runner)
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(AllTests.class);
    }
}
