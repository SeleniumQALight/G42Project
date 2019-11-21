package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin () {
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("909090");
        loginPage.clickonButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());

    }
    
    @Test
    public void invalidPassword(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword("qwerty");
        loginPage.clickonButtonVhod();
        checkExpectedResult("Button Vhod is not present", loginPage.isSubmitButtonPresent());
    }
    
}
