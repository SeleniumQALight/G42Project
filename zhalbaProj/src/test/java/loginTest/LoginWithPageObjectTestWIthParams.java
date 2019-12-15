package loginTest;

import abstractParentTest.AbstractParentTest;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)

public class LoginWithPageObjectTestWIthParams extends AbstractParentTest {

  String login, pass;

  public LoginWithPageObjectTestWIthParams(String login, String pass) {
    this.login = login;
    this.pass = pass;
  }

  @Parameterized.Parameters(name = "Parameters are {0} and {1}")
  public static Collection testData() {
    return Arrays.asList(new Object[][]{
            {"Student", "909090"},
            {"Login", "9090900"}
        }
    );
  }


  @Test
  public void validLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin(login);
    loginPage.enterPassInToInputPassword(pass);
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

  }

  @Test
  public void invalidLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin(login);
    loginPage.enterPassInToInputPassword(pass);
    loginPage.clickOnButtonVhod();

    checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
    checkExpectedResult("Button is not displayed", loginPage.isVhodButtonDispalyed());
  }
}
