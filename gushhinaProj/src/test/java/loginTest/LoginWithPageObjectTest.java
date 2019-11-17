package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        //if isAvatarDisplayed is false, the message will be shown
        checkExpectedResult("Avatar is not present.", homePage.isAvatarDisplayed());



    }


}
