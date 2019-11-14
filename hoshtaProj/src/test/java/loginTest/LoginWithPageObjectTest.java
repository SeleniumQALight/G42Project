package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("906090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Vhod button is not visible", loginPage.isVhodButtonVisible());
    }
}