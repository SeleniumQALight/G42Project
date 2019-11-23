package sparesTests;

import abstractParentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    final String spareName = "DubynaSpare";
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.clickOnAddButton();
        editSparePage.buttonCreateIsDisplayed();
        editSparePage.inputSpareNameIntoSpareNameField(spareName);
        //editSparePage.selectSpareTypeFromDropDown();
        editSparePage.selectSpareTypeFromDropDownMethodJava("Датчики"); //choosing value from drop down with help of Java
        editSparePage.clickOnCreateSpareButton();
        sparePage.checkDictionaryPageisDisplayed();
        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
        //sparePage.checkNewSpare();



    }

    @After
    public void deleteSpare (){
        sparePage.deleteSpareUntilPresent (spareName);

    }

}