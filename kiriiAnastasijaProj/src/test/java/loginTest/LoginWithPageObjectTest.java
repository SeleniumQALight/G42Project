package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterloginInToInputLogin("Student");
        loginPage.enterPassInToInputPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present"
                , homePage.isAvatarDisplayed());
    }
}