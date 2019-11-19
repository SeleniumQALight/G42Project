package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
      loginPage.openPage();
      loginPage.enterLoginInToInputLogin("Student");
      loginPage.enterPassInToInputPassWord("909090");
      loginPage.clickOnButtonVhod();

      checkExpectedResult("Avatar is not present", homePage.isAvatarDisplaied());
    }

    @Test
    public void unValidLogin () {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Studentrtfd");
        loginPage.enterPassInToInputPassWord("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not be present", ! homePage.isAvatarDisplaied());
    }

    @Test
    public void wrongPassword () {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassWord("909090$$$$");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar should not be present", ! homePage.isAvatarDisplaied());
    }

    @Test
    public void upperCaseLogin () {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("STUDENT");
        loginPage.enterPassInToInputPassWord("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplaied());
    }

}
