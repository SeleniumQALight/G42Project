package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

  @Test
  public void validLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("909090");
    loginPage.clickonButtonVhod();


    checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

  }

  @Test
  public void invalidLogin() {
    loginPage.openPage();
    loginPage.enterLoginInToInputLogin("Student");
    loginPage.enterPassInToInputPassword("909095");
    loginPage.clickonButtonVhod();

    checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
    checkExpectedResult("Button is not displayed", loginPage.isVhodButtonDispalyed());
  }
}
