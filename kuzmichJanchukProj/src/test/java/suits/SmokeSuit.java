package suits;

import loginTest.LoginWithPageObject;
import loginTest.LoginWithPageObjectWithParams;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sparestest.SparesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObject.class,
                LoginWithPageObjectWithParams.class,
                SparesTest.class
        }
)
public class SmokeSuit {
}
