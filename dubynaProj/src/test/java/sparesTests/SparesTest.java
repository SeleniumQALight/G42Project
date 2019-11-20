package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    final String spareName = "DubynaSpare";
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.buttonCreateIsDisplayed();
        editSparePage.inputSpareNameIntoSpareNameField(spareName);
        editSparePage.selectSpareTypeFromDropDown();
        editSparePage.clickOnCreateSpareButton();
        dictionarySpares.checkDictionaryPageisDisplayed();
        dictionarySpares.checkNewSpare();

    }
}