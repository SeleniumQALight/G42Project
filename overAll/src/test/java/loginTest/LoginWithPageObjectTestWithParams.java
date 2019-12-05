package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectTestWithParams extends AbstractParentTest{
    String login, pass;

    public LoginWithPageObjectTestWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                    {"Student", "909090"},
                    {"login", "909090"}
                }
        );
    }

    @Test
    public void unvalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin(login);
        loginPage.enterPassInToInputPassWord(pass);
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not be present"
                , !homePage.isAvatarDisplayed());

    }


}
