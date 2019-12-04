package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectWithParamsTest extends AbstractParentTest {
    String login, password;

    public LoginWithPageObjectWithParamsTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                        {"Student", "906090"},
                        {"IncorrectLogin", "909090"}
                }
        );
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin(login);
        loginPage.enterPasswordIntoInputPassword(password);
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Login field is not displayed", loginPage.isLoginFieldDisplayed());
        checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
    }

}
