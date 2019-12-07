package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "popelnukhSpare" + Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubMenuSpares();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpares();

        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectFromDropDownTypeOfSpare("Датчики");
        editSparePage.clickOnSubmitButton();
        sparePage.checkCurrentUrl();
        checkExpectedResult("Can't find spare"
                , sparePage.isSpareInList(spareName));

    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}