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
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void validLoginUppercase() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("STUDENT", "909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void validLoginLowercase() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
    @Test
    public void emptyData() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("", "");
        loginPage.checkCurrentUrl();
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginValidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student1", "909090");
        loginPage.checkCurrentUrl();
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginInvalidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student1", "000000");
        loginPage.checkCurrentUrl();
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }
    @Test
    public void validLoginInvalidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student", "000000");
        loginPage.checkCurrentUrl();
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }
}

