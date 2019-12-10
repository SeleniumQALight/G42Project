package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectTestWithParameters extends AbstractParentTest {
    String login;
    String password;

    public LoginWithPageObjectTestWithParameters(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0}, {1}")
    public  static Collection testData () {
        return Arrays.asList(new Object[][] {
                {"Student", "909090"},
                {"login", "909090"}

                }

        );
    }
    @Test
    public void UnValidLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin(login);
        loginPage.enterPassIntoInputPassword(password);
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar should  not be present", true, !homePage.isAvatarDisplayed());

    }
    

    
}
