package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWithPageObjectTest extends AbstractParentTest {

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

        checkExpectedResult("Wrong URL", checkCurrentUrl(loginPage.Url));
        checkExpectedResult("Button vhod is not present", loginPage.isButtonVhodDisplayed());
    }
}
