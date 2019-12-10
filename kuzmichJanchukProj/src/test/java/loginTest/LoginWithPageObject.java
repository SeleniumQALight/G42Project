package loginTest;

import abstractparenttest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObject extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoLoginField("Student");
        loginPage.enterPasswordIntoPasswordField("909090");
        loginPage.clickOnButtonEnter();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed() );
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();

        loginPage.enterLoginIntoLoginField("Student");
        loginPage.enterPasswordIntoPasswordField("zero");
        loginPage.clickOnButtonEnter();
        expectElementNotPresent("Strange! Login successful with bad credentials", homePage.isAvatarDisplayed());

        loginPage.enterLoginIntoLoginField("zero");
        loginPage.enterPasswordIntoPasswordField("909090");
        loginPage.clickOnButtonEnter();
        expectElementNotPresent("Strange! Login successful with bad credentials", homePage.isAvatarDisplayed());
    }
}
