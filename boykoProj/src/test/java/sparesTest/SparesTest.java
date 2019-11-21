package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.enterSpareName("BoykoZhannaSpare1");
        editSparePage.selectSpareTypeFromDropDown(); //датчики
        editSparePage.clickOnSubmitButton();
        checkExpectedResult("Spare is not found", sparePage.isSpareDisplayed());

    }
}
