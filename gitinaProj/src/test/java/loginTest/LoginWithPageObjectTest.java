package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
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
        logInPage.openPage();
        logInPage.enterLoginInToInputlogin("Student");
        logInPage.enterPassInToInputPassWord("909090");
        logInPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present",
                homePage.isAvatarDisplayed());


    }
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test

    public void invalidLogin() {

        logInPage.openPage();

        logInPage.enterLoginInToInputlogin("Student");
        logInPage.enterPassInToInputPassWord("90909");
        logInPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not be present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Vhod button is not displayed", logInPage.isButtonVhodDisplayed());
        checkExpectedResult("email field button is not displayed", logInPage.isEmailFieldDisplayed());
        checkExpectedResult("email field button is not displayed", logInPage.isPasswordFieldDisplayed());

    }

}
