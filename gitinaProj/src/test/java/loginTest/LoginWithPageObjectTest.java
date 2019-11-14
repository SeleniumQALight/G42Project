package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin() {
        logInPage.openPage();
        logInPage.enterLoginInToinputlogin("Student");
        logInPage.enterPassInToInputPassWord("909090");
        logInPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present",
                homePage.isAvatarDisplayed());


    }
//////////////@Test  invalid login

}
