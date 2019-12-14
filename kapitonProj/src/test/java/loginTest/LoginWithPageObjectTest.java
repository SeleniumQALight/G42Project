package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;
import pages.LoginPage;
@Epic("Allure examples")
@Feature("Junit 4 support")

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
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