package sparesTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "BoykoZhannaSpare"+ Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubmenuSpares();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpare();
        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();
//        editSparePage.enterSpareName("BoykoZhannaSpare1");
//        editSparePage.selectSpareTypeFromDropDown(); //датчики
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();
        sparePage.checkCurrentUrl();
//        checkExpectedResult("Spare is not found", sparePage.isSpareDisplayed());
        checkExpectedResult("Can not find spare in List", sparePage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare (){
        sparePage.deleteSpareUntilPresent(spareName);

    }
}
