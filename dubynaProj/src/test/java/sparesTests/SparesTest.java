package sparesTests;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    final String spareName = "DubynaSpare" + Utils.getDateAndTimeFormated();
    @Test
    public void addNewSpare() {
        loginPage.fillingLoginFormAndSubmit("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuSpares();
        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);
        sparePage.clickOnAddButton();
        editSparePage.checkCurrentUrl();
        editSparePage.buttonCreateIsDisplayed();
        editSparePage.inputSpareNameIntoSpareNameField(spareName);
        //editSparePage.selectSpareTypeFromDropDown();
        editSparePage.selectSpareTypeFromDropDownMethodJava("Датчики"); //choosing value from drop down with help of Java
        editSparePage.clickOnCreateSpareButton();
        sparePage.checkCurrentUrl();
        sparePage.checkDictionaryPageisDisplayed();
        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
        //sparePage.checkNewSpare();



    }

    @After
    public void deleteSpare (){
        sparePage.deleteSpareUntilPresent (spareName);

    }

}