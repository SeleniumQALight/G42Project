package dealsTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class DealsTest extends AbstractParentTest {
    @Test
    public void changeCheckBoxState(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();

        providersPage.clickOnAddButton();

        editProvidersPage.setStateToCheckboxPrivatePerson ("Y");
        editProvidersPage.setStateToCheckboxIsOurFirm ("N");




    }
}
