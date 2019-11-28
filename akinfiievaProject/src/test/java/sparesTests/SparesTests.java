package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;


public class SparesTests extends AbstractParentTest {
    private final String spareName = "G42_AkinfiievaSpare"+ Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnButtonAdd();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        //  editSparePage.clickSpareTypeFromDropDownList("Датчики");
        editSparePage.clickButtonCreate();
        sparePage.checkCurrentUrl();
        checkExpectedResult("Can't find created spare in list", sparePage.isSpareAddedToDictionary(spareName));
    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
