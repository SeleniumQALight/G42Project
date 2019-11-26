package sparesTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "VetrichenkoSpare" + Utils.getDateAndTimeFormated();

    @Test
    public void addNewSpareTest() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.CheckCurrentUrl();
        //homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        sparePage.CheckCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();

        editSparesPage.CheckCurrentUrl();
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
