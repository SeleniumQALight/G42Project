package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassWord("909090");
        loginPage.clickOnButtonVhod();

        //кейс когда мы не указываем переменную
        checkExpectedResult("Avatar is not present"
                , homePage.isAvatarDisplayed());

    }


}
