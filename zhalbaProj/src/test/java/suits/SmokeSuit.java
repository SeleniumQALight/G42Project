package suits;

import loginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sparesTests.SparesTest;

@RunWith(Suite.class)
@SuiteClasses(
    {
        LoginWithPageObjectTest.class,
        SparesTest.class
    }

)
public class SmokeSuit {

}
