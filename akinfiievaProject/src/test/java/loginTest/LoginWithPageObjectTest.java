package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPasswordIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }

    @Test
    public void notValidLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPasswordIntoInputPassword("905090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Login page hasn't loaded", homePage.isLoginBoxRefreshed());
    }

}
