package loginTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {
    @Test
    public void validLogin(){
        tryToLoginAsStudentWithPassword("909090");
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

    @Test
    public void invalidLogin(){
        tryToLoginAsStudentWithPassword("906090");
        checkExpectedResult("Avatar is present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Vhod button is not visible", loginPage.isVhodButtonVisible());
    }

    private void tryToLoginAsStudentWithPassword(String password){
        loginPage.openPage();
        loginPage.enterLoginIntoInputLogin("Student");
        loginPage.enterPassIntoInputPassword(password);
        loginPage.clickOnButtonVhod();
    }
}