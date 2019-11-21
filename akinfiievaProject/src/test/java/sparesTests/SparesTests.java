package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;


public class SparesTests extends AbstractParentTest {
    private final String spareName = "G42_AkinfiievaSpare";

    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnButtonAdd();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        //  editSparePage.clickSpareTypeFromDropDownList("Датчики");
        editSparePage.clickButtonCreate();
        checkExpectedResult("Can't find created spare in list", sparePage.isSpareAddedToDictionary(spareName));
    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }
}
