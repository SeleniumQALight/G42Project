package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by Андрей Гугля on 12.11.2019.
 */
public class LoginWithPageObject extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
    }
}
