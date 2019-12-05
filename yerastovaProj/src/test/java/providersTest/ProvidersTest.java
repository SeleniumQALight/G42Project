package providersTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class ProvidersTest extends AbstractParentTest {
    @Test
    public void changeCheckBoxState(){
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");

        homePage.checkIsAvatarPresent();
       // homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();

        providersPage.clickOnAddButton();

        editProvidersPage.setStateToCheckboxPrivatePerson ("Check");
        editProvidersPage.setStateToCheckboxIsOurFirm ("uncheck");




    }
}
