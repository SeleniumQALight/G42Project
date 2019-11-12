package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin () {
        loginPage.openPage();

    }
}
