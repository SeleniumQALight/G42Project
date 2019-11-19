package sparesTest;

import abstractParrentTest.AbstractParentTest;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {
    @Test
    public void addNewSpare(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIfAvatarIsPresent();
        homePage.clickOnDictionaryMenu();
        homePage.clickOnSparesSubMenu();
        sparesPage.checkIfAddButtonIsDisplayed();
        sparesPage.clickAddButton();
        dictionaryPage.checkIfCreateButtonIsDisplayed();
        dictionaryPage.inputSpareName("G42 Hoshta");
        int a = 2;
    }
}
