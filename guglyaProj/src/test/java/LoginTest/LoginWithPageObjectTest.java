package LoginTest;

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





}
