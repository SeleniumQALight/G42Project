package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Андрей Гугля on 12.11.2019.
 */
@RunWith(Parameterized.class)
public class LoginWithPageObjectTestWithParams extends AbstractParentTest {
    String login, pass;

    public LoginWithPageObjectTestWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Student", "906090"},
                {"login", "909090"}
                }

        );
    }

    @Test
    public void unvalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin(login);
        loginPage.enterPassInToInputPassword(pass);
        loginPage.clickOnButtonVhod();

        checkExpextedResult("Avatar should not present" , !homePage.isAvatarDisplayed());

    }


//    @Test
//    public void wrongPass(){
//        loginPage.openPage();
//        loginPage.enterLoginInToInputLogin("Student");
//        loginPage.enterPassInToInputPassword("906090");
//        loginPage.clickOnButtonVhod();
//
//        checkExpextedResult("Still stay on login page", loginPage.stayOnLoginPageChek());
//    }



}
