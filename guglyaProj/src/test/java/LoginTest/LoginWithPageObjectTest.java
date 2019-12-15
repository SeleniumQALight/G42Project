package LoginTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Андрей Гугля on 12.11.2019.
 */

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
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpextedResult("Avatar is not present" , homePage.isAvatarDisplayed());

    }

    @Ignore
    @Test
    public void wrongPass(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("906090");
        loginPage.clickOnButtonVhod();

        checkExpextedResult("Still stay on login page", loginPage.stayOnLoginPageChek());
    }



}
