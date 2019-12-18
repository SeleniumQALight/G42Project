package suits;

import LoginTest.LoginWithPageObject;
import LoginTest.LoginWithPageObjectWithParams;
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
