package loginTest;

import abstractParrentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
//@Epic("Allure examples")
//@Feature("Junit 4 support")

public class LoginWithPageObjectTest extends AbstractParentTest {
  /*  @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
*/
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        //if isAvatarDisplayed is false, the message will be shown
        checkExpectedResult("Avatar is not present.", homePage.isAvatarDisplayed());

    }
    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("studentishka");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        correctLogin("Home page is not opened!", !homePage.isLogginSuccess());
    }



}
