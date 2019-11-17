package loginTest;

import abstractPackageTest.AbstractParentClass;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentClass {
    @Test
    public void ValidLogin() {
        loginPage.openPage();
        loginPage.enterLoginInToInputLogin("Student");
        loginPage.enterPassInToInputPassword("909090");
        loginPage.clickOnButtonVhod();

        checkExpectedResult("Avatar is not present",
                homePage.isAvatarDisplayed());
    }

    @Test
    public void InvalidLogin() {

    }

}
