package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class SparesTest extends AbstractParentTest {
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnAddButton();

    }
}