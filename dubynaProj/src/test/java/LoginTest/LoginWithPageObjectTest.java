package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;


public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();
        // Assert.assertTrue("Avatar is not present", homePage.isAvatarDisplayed());
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void loginWithWrongPass() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909009");
        loginPage.clickOnButtonVhod();
        Assert.assertTrue("User is logged in with wrong pass", loginPage.buttonVhodIsDisplayed());

    }


}
