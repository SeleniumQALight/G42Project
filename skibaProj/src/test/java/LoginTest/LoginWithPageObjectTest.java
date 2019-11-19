package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassWord("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present"
                , homePage.isAvatarDisplayed());

    }


}
