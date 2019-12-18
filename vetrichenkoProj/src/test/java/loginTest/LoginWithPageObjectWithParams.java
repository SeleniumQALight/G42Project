package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectWithParams extends AbstractParentTest {
/*    @Test
    public void validLoginTest() {
        loginPage.openPage();
        loginPage.enterLoginIntoLogin("Student");
        loginPage.enterPassIntoPass("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is present", homePage.isAvatarDisplayed());
    }*/

    String login, pass;

    public LoginWithPageObjectWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData()
    {
        return Arrays.asList(new Object[][] {
                {"Student", "906090"},
                {"Student1", "909090"}
            }
        );
    }

    @Test
    public void unValidLoginTest() {
        loginPage.openPage();
        loginPage.enterLoginIntoLogin(login);
        loginPage.enterPassIntoPass(pass);
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar isn`t present", !homePage.isAvatarDisplayed());
    }


}
