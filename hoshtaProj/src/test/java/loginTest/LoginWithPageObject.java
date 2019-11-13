package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObject extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
    }
}
