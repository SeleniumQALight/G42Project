package LoginTest;

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
}
