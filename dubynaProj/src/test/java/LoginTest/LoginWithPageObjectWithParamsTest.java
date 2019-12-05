package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class LoginWithPageObjectWithParamsTest extends AbstractParentTest {
    String login, pass;

    public LoginWithPageObjectWithParamsTest(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"login","909090"}
                }

        );
    }


    @Test
    public void unValidLogin() {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin(login);
        loginPage.enterPassIntoInputPassword(pass);
        loginPage.clickOnButtonVhod();
        Assert.assertTrue("Button Vhod Should Not Be Present", loginPage.buttonVhodIsDisplayed());

    }


}
