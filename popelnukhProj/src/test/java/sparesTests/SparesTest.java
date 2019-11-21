package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "popelnukhSpare";
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();


        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectFromDropDownTypeOfSpare("Датчики");
        editSparePage.clickOnSubmitButton();
        checkExpectedResult("Can't find spare"
                , sparePage.isSpareInList(spareName));

    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareUntilPresent(spareName);
    }
}