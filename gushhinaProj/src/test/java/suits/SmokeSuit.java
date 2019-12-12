package suits;


import loginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sparesTests.SparesTest;

//tut vnosimo shcho bude zapuskatus' dlya smoke test. Tak mozna zrobiti dlya bud' yakih.
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                SparesTest.class

        }
)
public class SmokeSuit {
}
