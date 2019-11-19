package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLoginTest() {
        loginPage.openPage();
        loginPage.enterLoginIntoLogin("Student");
        loginPage.enterPassIntoPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar isn`t present", homePage.isAvatarDisplayed());
    }

    @Test
    public void unValidLoginTest() {
        loginPage.openPage();
        loginPage.enterLoginIntoLogin("Student");
        loginPage.enterPassIntoPass("909099");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar isn`t present", !homePage.isAvatarDisplayed());
    }

}
