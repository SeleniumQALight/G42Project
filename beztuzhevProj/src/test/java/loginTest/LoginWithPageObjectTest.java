package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void emptyData() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("");
        loginPage.enterPassInToInputPassword("");
        loginPage.clickOnButtonVhod();
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginValidPass() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student1");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }

    @Test
    public void invalidLoginInvalidPass() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student1");
        loginPage.enterPassInToInputPassword("000000");
        loginPage.clickOnButtonVhod();
        Assert.assertEquals(loginPage.getCurrentUrl(), "http://v3.test.itpmgroup.com/login");
        Assert.assertEquals(loginPage.getTitle(), "Account of spare:Авторизация");
        Assert.assertTrue("ButtonVhod is displayed", loginPage.isPageLoaded());
    }
}

