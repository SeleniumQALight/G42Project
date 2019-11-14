package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin () {
        loginPage.openPage();
    }
}
