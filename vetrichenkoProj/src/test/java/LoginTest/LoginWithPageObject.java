package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObject extends AbstractParentTest {
    @Test
    public void validLoginTest() {
        loginPage.openPage();
    }
}
