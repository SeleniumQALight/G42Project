package sparesTest;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    private final String spareName = "BoykoZhannaSpare";
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnAddButton();
//        editSparePage.enterSpareName("BoykoZhannaSpare1");
//        editSparePage.selectSpareTypeFromDropDown(); //датчики
        editSparePage.enterSpareNameInToInput(spareName);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();
//        checkExpectedResult("Spare is not found", sparePage.isSpareDisplayed());
        checkExpectedResult("Can not find spare in List", sparePage.isSpareInList(spareName));


    }

    @After
    public void deleteSpare (){
        sparePage.deleteSpareUntilPresent(spareName);

    }
}
