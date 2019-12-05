package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginWithPageObjectWithParams extends AbstractParentTest {
    String login, pass;

    public LoginWithPageObjectWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }
@Parameterized.Parameters(name = "Parameters are {0} and {1}")
public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student","906090"},
                {"login","909090"},
                {"","909090"}
                }

        );
}
    @Test
    public void unvalidLogin() {
        logInPage.openPage();
        logInPage.enterLoginInToInputlogin(login);
        logInPage.enterPassInToInputPassWord(pass);
        logInPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not present",
              !  homePage.isAvatarDisplayed());


    }

}
