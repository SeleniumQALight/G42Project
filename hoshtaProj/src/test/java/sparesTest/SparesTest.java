package sparesTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Assert;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    @Test
    public void addNewSpare(){
        String spareName = "G42 Hoshta";
        String spareTypeValue = "Датчики";
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIfAvatarIsPresent();
        homePage.clickOnDictionaryMenu();
        homePage.clickOnSparesSubMenu();
        int amountOfSparesBeforeUpdate = sparesPage.getAmountOfSpares();
        sparesPage.checkIfAddButtonIsDisplayed();
        sparesPage.clickAddButton();
        dictionaryPage.checkIfCreateButtonIsDisplayed();
        dictionaryPage.inputSpareName(spareName);
        dictionaryPage.expandSpareTypeDropdownAndSelectValue(spareTypeValue);
        dictionaryPage.clickCreateButton();
        Assert.assertEquals("Amount of spares is not updated",amountOfSparesBeforeUpdate + 1, sparesPage.getAmountOfSpares());
        Assert.assertEquals("The last spare name is not correct", sparesPage.getLastSpareName(), spareName);
        Assert.assertEquals("The last spare type is not correct", sparesPage.getLastSpareType(), spareTypeValue);
    }
}
