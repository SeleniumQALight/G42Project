package suits;

import loginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sparesTests.SparesTest;

/**
 * Created by Андрей Гугля on 03.12.2019.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                SparesTest.class
        }
)
public class SmokeSuit {
}
