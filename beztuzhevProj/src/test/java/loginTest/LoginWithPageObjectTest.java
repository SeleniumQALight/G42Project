package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

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
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginValidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student1", "909090");
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginInvalidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student1", "000000");
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }
    @Test
    public void validLoginInvalidPass() {
        loginPage.openPage();
        loginPage.fillingLoginFormAndSubmitIt("Student", "000000");
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }
}

