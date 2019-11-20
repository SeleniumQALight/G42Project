package LoginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
       loginPage.openPage();
       loginPage.enterLoginIToInputLogin("Student");
       loginPage.enterPassInToPassword("909090");
       loginPage.clickOnButtonVhod();

       checkExpectedResult("Avatar is not present", homePage. isAvatarDisplayed());


    }

    @Test
    public void WrongPass(){
    loginPage.openPage();
    loginPage.enterLoginIToInputLogin("Student");
    loginPage.enterPassInToPassword("906090");
    loginPage.clickOnButtonVhod();

       checkExpectedResult("WRONG PASSWORD", loginPage.stayOnLoginPageChek());
    }


}
