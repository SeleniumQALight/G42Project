package sparesTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "TestSpare" + Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpare() {
        loginPage.fillLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();

        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(spareName);
        editSparePage.selectSpareTypeFromDropDown("4");
        editSparePage.clickOnSubmitButton();
        sparePage.checkCurrentUrl();
        checkExpectedResult("Can not find spare in list",
                sparePage.isSpareInList(spareName));
    }


    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }

}
