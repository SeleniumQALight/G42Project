package suits;

import LoginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sparesTests.SparesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                SparesTest.class
        }
)

public class SmokeSuit  {

}