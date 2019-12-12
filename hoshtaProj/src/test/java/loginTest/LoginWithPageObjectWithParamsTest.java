package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectWithParamsTest extends AbstractParentTest {
    private String login, pass;

    public LoginWithPageObjectWithParamsTest(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameteres are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                    {"Student", "909090"},
                    {"Student1", "909090"},
                    {"Studenwwt1", "wwww"}
                }
        );
    }

    @Test
    public void unvalidLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin(login);
        loginPage.enterPassIntoInputPassword(pass);
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is  present", !homePage.isAvatarDisplayed());
    }

}