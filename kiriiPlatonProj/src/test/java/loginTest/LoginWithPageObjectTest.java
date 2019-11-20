package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPasswordIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not present",homePage.isAvatarDisplayed());
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPasswordIntoInputPassword("invalidPassword");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Login field is not displayed", loginPage.isLoginFieldDisplayed());
        checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
    }

}
