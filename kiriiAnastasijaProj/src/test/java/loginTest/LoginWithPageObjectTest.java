package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Assert;
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
        loginPage.openPage();
        loginPage.enterloginInToInputLogin("Student");
        loginPage.enterPassInToInputPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present"
                , homePage.isAvatarDisplayed());
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.enterloginInToInputLogin("sudent");
        loginPage.enterPassInToInputPass("909090");
        loginPage.clickOnButtonVhod();
        Assert.assertEquals("Wrong current Page", "http://v3.test.itpmgroup.com/login",
                loginPage.currentUrl());
    }
}
