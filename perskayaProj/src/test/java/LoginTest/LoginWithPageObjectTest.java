package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest {
@Test
    public void validLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("909090");
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed()); //ожидаемый результат

}

}
