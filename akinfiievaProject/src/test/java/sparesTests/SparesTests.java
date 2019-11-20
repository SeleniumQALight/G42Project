package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class SparesTests extends AbstractParentTest {
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student","909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();

        sparePage.clickOnButtonAdd();
        sparePage.enterSpareName();
        sparePage.chooseSpareType(); //mechanika
        sparePage.clickonButtonCreate();



    }
}
