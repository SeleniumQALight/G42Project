package loginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.Test;

@Epic("Allure examples")
@Feature("Junit 4 support")

public class LoginWithPageObjectTest extends AbstractParentTest {
   // @Ignore - что-бы скипнуть один тест
   @Description("Some detailed test description")
   @Story("Base support for bdd annotations")
   @Link("https://example.org")
   @Link(name = "allure", type = "mylink")
   @Issue("123")
   @Issue("432")
   @Severity(SeverityLevel.CRITICAL)
    @Test
    public void validLoginTest() {
        loginPage.openPage();
        loginPage.enterLoginIntoLogin("Student");
        loginPage.enterPassIntoPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is present", homePage.isAvatarDisplayed());
    }

//    @Test
//    public void unValidLoginTest() {
//        loginPage.openPage();
//        loginPage.enterLoginIntoLogin("Student");
//        loginPage.enterPassIntoPass("909099");
//        loginPage.clickOnButtonVhod();
//
//        checkExpectedResult("Avatar isn`t present", !homePage.isAvatarDisplayed());
//    }


}
