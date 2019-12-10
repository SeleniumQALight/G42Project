package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

/**
 * Created by Андрей Гугля on 12.11.2019.
 */
public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpextedResult("Avatar is not presrnt" , homePage.isAvatarDisplayed());

    }


    @Test
    public void wrongPass(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("906090");
        loginPage.clickOnButtonVhod();

        checkExpextedResult("Still stay on login page", loginPage.stayOnLoginPageChek());
    }



}
