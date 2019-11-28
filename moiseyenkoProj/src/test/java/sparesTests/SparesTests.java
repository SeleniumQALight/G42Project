package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTests extends AbstractParentTest {
    private final String spareName = "MoiseyenkoSpare" + Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();

 //       editSparePage.inputSpareNameIntoSpareNameField(spareName);
 //       editSparePage.selectSpareTypeFromDropDown();
//        editSparePage.clickOnCreateSpareButton();
//        sparePage.checkDictionaryPageisDisplayed();
//        sparePage.checkNewSpare();
//        The part of previous homework

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();

        sparePage.checkCurrentUrl();

        checkExpectedResult("Cannot find spare in list", sparePage.isSpareInList(spareName));


    }
     @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
