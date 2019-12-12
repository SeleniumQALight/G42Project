package sparesTest;

import abstractParrentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    String spareName = "G42 Hoshta" + Utils.getDateAndTimeFormated();
    String spareTypeValue = "Датчики";

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIfAvatarIsPresent();
//        homePage.clickOnDictionaryMenu();
//        homePage.clickOnSparesSubMenu();
        homePage.leftMenu.clickDictionaryMeny();
        homePage.leftMenu.clickSparesSubMeny();
        sparesPage.checkCurrentUrl();
        sparesPage.checkIfAddButtonIsDisplayed();
        sparesPage.clickAddButton();
        editSparePage.checkCurrentUrl();
        editSparePage.checkIfCreateButtonIsDisplayed();
        editSparePage.inputSpareName(spareName);
        //editSparePage.expandSpareTypeDropdownAndSelectValue(spareTypeValue);
        editSparePage.selectSpareTypeFromDropDown("Датчики");
        editSparePage.clickCreateButton();
        sparesPage.checkCurrentUrl();
        Assert.assertEquals("The last spare name is not correct", sparesPage.getLastSpareName(), spareName);
        Assert.assertEquals("The last spare type is not correct", sparesPage.getLastSpareType(), spareTypeValue);
        checkExpectedResult("Can not find spare in list", sparesPage.isSpareInList(spareName));
    }

    @After
    public void removeAddedSpare() {
        //sparesPage.clickRow(spareName);
        sparesPage.deleteSpareUntilPresent(spareName);
        //editSparePage.clickDeleteButton();
    }
}
