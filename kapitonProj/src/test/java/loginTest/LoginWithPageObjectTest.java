package loginTest;

import abstractParentTest.AbstractParentTest;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage(); //открывает нужную страницу
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickInToButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void unValidLogin() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("9090");
        loginPage.clickInToButtonVhod();
        checkExpectedResult("Avatar should not be present", !homePage.isAvatarDisplayed());
    }
}