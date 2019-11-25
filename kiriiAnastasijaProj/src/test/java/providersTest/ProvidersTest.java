package providersTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;

public class ProvidersTest extends AbstractParentTest {
    @Test
    public void editProvidersDeal() {
        loginPage.fillLoginFormAndSubmitIt("Student", "909090");
        homePage.checkIsAvatarPresent();
        homePage.clickOnMenuDictionary();
        homePage.clickOnMenuProviders();
        providersPage.clickOnAddProviderButton();
        editProvidersPage.privatePersonCheckbox("check");
    }
}
