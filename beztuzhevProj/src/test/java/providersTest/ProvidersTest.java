package providersTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class ProvidersTest extends AbstractParentTest {
    @Test
    public void editProvidersDeal() {
        loginPage.fillingLoginFormAndSubmitIt("Student", "909090");
        homePage.checkCurrentUrl();
        homePage.checkIsAvatarPresent();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnMenuSpares();

        providersPage.checkCurrentUrl();
        providersPage.clickOnAddProviderButton();

        editProvidersPage.checkCurrentUrl();
        editProvidersPage.privatePersonCheckbox("check");
    }
}
