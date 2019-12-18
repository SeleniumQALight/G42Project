package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    @Test
    public void unValidLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("");
        loginPage.enterPassIntoInputPassword("");
        loginPage.clickOnButtonVhod();

//        checkExpectedResult("Wrong URL", loginPage.checkCurrentUrl());
        loginPage.checkCurrentUrl();
        checkExpectedResult("Button vhod is not present", loginPage.isButtonVhodDisplayed());
    }
}
