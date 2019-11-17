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
    public void wrongPassword() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPasswordIntoInputPassword("909090909090909099999");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Login page hasn't loaded", homePage.isLoginBoxRefreshed());
    }

    @Test
    public void wrongLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Studeeent");
        loginPage.enterPasswordIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Login page hasn't loaded", homePage.isLoginBoxRefreshed());
    }


    @Test
    public void lowcaseLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("student");
        loginPage.enterPasswordIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void uppercaseLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("STUDENT");
        loginPage.enterPasswordIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
