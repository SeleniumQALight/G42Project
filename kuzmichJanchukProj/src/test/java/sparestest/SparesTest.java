package sparestest;

import abstractparenttest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

    private final String SPARE_NAME = "Kuzmych_Inchuk_Spare";

    @Test
    public void addNewSpare() {
        loginPage.fillLoginFormAndSubmit("Student", "909090");

        homePage.isAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();

        //Implementation 1 - homework
//        sparePage.clickOnAddButton();
//        sparePage.openDropDown();
//        sparePage.fillInSpareName("G42Project_Kuzmych-Ianchuk");
//        sparePage.selectFromDropDownOptions("Датчики");
//        sparePage.clickOnCreateButton();

        //Implementation 2 - Classwork
        sparePage.clickOnAddButton();
        editSparePage.enterSpareNameIntoInput(SPARE_NAME);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickOnSubmitButton();
        checkExpectedResult("Cannot find spare in list", sparePage.isSpareInList(SPARE_NAME));
    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(SPARE_NAME);
    }
}
