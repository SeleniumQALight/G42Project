package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "VetrichenkoSpare";

    @Test
    public void addNewSpareTest() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.clickOnAddButton();

        editSparesPage.enterSpareNameIntoInput(spareName);
        editSparesPage.selectSpareTypeFromDropDown("Датчики");
        editSparesPage.clickOnSubmitButton();

        checkExpectedResult("can`t find spare in list", sparePage.isSpereInList(spareName));

    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }

}
