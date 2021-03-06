package sparesTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class SparesTest extends AbstractParentTest {

    private final String spareName = "GitinaSpare1" + Utils.getDateAndTimeFormated();

    @Test
    public void adNewSpare() {
        logInPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();

        homePage.checkIsAvatarPresent();
//        homePage.clickOnMenuDictionary();
//        homePage.clickOnSubMenuSpares();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubMenuSpare();
        sparePage.checkCurrentUrl();
        sparePage.deleteSpareUntilPresent(spareName);

        sparePage.clickOnAddButton();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareNameIntoInput(spareName);
        editSparePage.selectSpareTypeFromDropDownText("новый вид типа запчасти");
        editSparePage.selectSpareTypeFromDropDownValue("1");
        editSparePage.clickOnSubmitButton();
        sparePage.checkCurrentUrl();
        checkExpectedResult("Cannot find spare in List", sparePage.isSpareInList(spareName));
    }

    @After
    public void deleteSpare() {
        sparePage.deleteSpareUntilPresent(spareName);
    }


    @Test
    public void testCheckBox() {
        logInPage.fillingLoginFormAndSubmitIt("Student", "909090");
    //    homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.clickOnAddButton();
        editProvidersPage.clickOnIsOurFirmCheckbox();
        checkExpectedResult("Checkbox is not enabled", editProvidersPage.IsOUrFirmCheckboxSelected());
        checkExpectedResult("Checkbox is not enabled", !editProvidersPage.isPrivatePersonCheckboxSelected());

    }
}
