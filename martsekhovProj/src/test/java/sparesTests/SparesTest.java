package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "MartsekhovSpare";
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparePage.clickOnAddButton();


    editSparePage.enterSpareNameInToInput(spareName);
    editSparePage.selectSpareTypeFromDropDown("Датчики");
    editSparePage.clickOnSubmitButton();

    checkExpectedResult ("Can not find spare in list"
            , sparePage.isSpareInList (spareName));

    }
    @After

    public void deleteSpare(){
      sparePage.deleteSpareUntilPresent(spareName);
    }
}
