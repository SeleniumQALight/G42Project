package loginTest;

import abstractParentTest.AbstractParentTest;
import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Test;
import pages.LoginPage;

public class LoginWithPageObjectTest extends AbstractParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage(); //открывает нужную страницу
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickInToButtonVhod();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());


    }

}
