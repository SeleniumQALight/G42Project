package loginTest;

import abstractParrentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Ignore;
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
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void invalidLogin(){
        loginPage.tryToLoginAsStudentWithPassword("906090");
        checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Vhod button is not visible", loginPage.isVhodButtonVisible());
        //pull from master
    }
}