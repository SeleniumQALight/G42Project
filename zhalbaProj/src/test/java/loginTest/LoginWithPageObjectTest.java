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



}
