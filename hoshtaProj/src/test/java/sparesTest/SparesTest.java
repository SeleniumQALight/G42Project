package sparesTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    String spareName = "G42 Hoshta";
    String spareTypeValue = "Датчики";

    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIfAvatarIsPresent();
        homePage.clickOnDictionaryMenu();
        homePage.clickOnSparesSubMenu();
        sparesPage.checkIfAddButtonIsDisplayed();
        sparesPage.clickAddButton();
        editSparePage.checkIfCreateButtonIsDisplayed();
        editSparePage.inputSpareName(spareName);
        editSparePage.expandSpareTypeDropdownAndSelectValue(spareTypeValue);
        editSparePage.clickCreateButton();
        Assert.assertEquals("The last spare name is not correct", sparesPage.getLastSpareName(), spareName);
        Assert.assertEquals("The last spare type is not correct", sparesPage.getLastSpareType(), spareTypeValue);
    }


    @After
    public void removeAddedSpare() {
        sparesPage.clickRow(spareName);
        editSparePage.clickDeleteButton();
    }
}
