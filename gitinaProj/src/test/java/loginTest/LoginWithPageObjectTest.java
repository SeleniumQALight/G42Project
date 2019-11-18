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

    @Test
    public void invalidLogin() {
        logInPage.openPage();
        logInPage.enterLoginInToinputlogin("Student");
        logInPage.enterPassInToInputPassWord("90909");
        logInPage.clickOnButtonVhod();

        checkExpectedResult("avatar is present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Vhod button is not displayed", logInPage.isButtonVhodDisplayed());
        checkExpectedResult("email field button is not displayed", logInPage.isEmailFieldDisplayed());
        checkExpectedResult("email field button is not displayed", logInPage.isPasswordFieldDisplayed());


    }

}
