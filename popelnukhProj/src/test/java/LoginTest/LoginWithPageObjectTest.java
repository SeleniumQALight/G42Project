package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Avatar is not present"
                , homePage.isAvatarDisplayed());
    }
    @Test
    public void unvalidLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("student");
        loginPage.enterPassInToInputPassword("90909");
        loginPage.clickOnButtonVhod();
        checkExpectedResult("Login proshel"
                , homePage.isButtonVhodDisplayed());
    }

}