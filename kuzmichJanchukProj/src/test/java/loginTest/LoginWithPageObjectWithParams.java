package loginTest;

import abstractparenttest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectWithParams extends AbstractParentTest {

    String login, password;

    public LoginWithPageObjectWithParams(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                {"Student", "906090"},
                {"login", "909090"}
        });
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoLoginField(login);
        loginPage.enterPasswordIntoPasswordField(password);
        loginPage.clickOnButtonEnter();
        checkExpectedResult("Strange! Login successful with bad credentials", !homePage.isAvatarDisplayed());
    }
}
